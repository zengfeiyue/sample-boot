package com.sample.common;

import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

@Component
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class PageInterceptor implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(PageInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        logger.info("进入拦截器");
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        //获取参数
        Object param = invocation.getArgs()[1];
        PageRequest pageRequest = this.getPageRequest(param);
        BoundSql boundSql = null;
        Object parameterObject = null;
        /**
         * 判断参数列表是否有PageRequest来判断是否需要进行分页
         */
        if (pageRequest != null) {
            Object whereParam = getWhereParameter(param);
            boundSql = mappedStatement.getBoundSql(whereParam);
            //强转 为了拿到分页数据
            String sql = boundSql.getSql();
            //获取相关配置
            Configuration config = mappedStatement.getConfiguration();
            Connection connection = config.getEnvironment().getDataSource().getConnection();
            //拼接查询当前条件的sql的总条数
            String countSql = "select count(*) from (" + sql + ") a";
            PreparedStatement preparedStatement = connection.prepareStatement(countSql);
//            BoundSql countBoundSql = new BoundSql(config, countSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
//            ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, countBoundSql);
//            parameterHandler.setParameters(preparedStatement);
            //执行获得总条数
            ResultSet rs = preparedStatement.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
            }
            String orderSql = bulidOrderBy(pageRequest);
            String pageSql;
            if (StringUtils.hasLength(orderSql)) {
                pageSql = sql + " order by " + orderSql + " limit " + pageRequest.getOffset() + " , " + pageRequest.getPageSize();
            } else {
                //拼接分页sql
                pageSql = sql + " limit " + pageRequest.getOffset() + " , " + pageRequest.getPageSize();
            }
            //重新执行新的sql
            doNewSql(invocation, pageSql);
            Object result = invocation.proceed();
            connection.close();
            //处理新的结构
            Page<?> page = new PageImpl<>((List) result, pageRequest, count);
            List<Page> returnResultList = new ArrayList<>();
            returnResultList.add(page);
            return returnResultList;
        }
        return invocation.proceed();
    }

    private String bulidOrderBy(PageRequest pageRequest) {
        Iterator<Sort.Order> iterator = pageRequest.getSort().stream().iterator();
        String orderSql = "";
        while (iterator.hasNext()) {
            Sort.Order next = iterator.next();
            if (StringUtils.hasLength(orderSql)) {
                orderSql = orderSql + "," + next.getProperty() + " " + next.getDirection().name();
            } else {
                orderSql = orderSql + next.getProperty() + " " + next.getDirection().name();
            }
        }
        return orderSql;
    }

    private void doNewSql(Invocation invocation, String sql) {
        final Object[] args = invocation.getArgs();
        MappedStatement statement = (MappedStatement) args[0];
        Object parameterObject = getWhereParameter(args[1]);
        BoundSql boundSql = statement.getBoundSql(parameterObject);
        MappedStatement newStatement = newMappedStatement(statement, new BoundSqlSqlSource(boundSql));
        MetaObject msObject = MetaObject.forObject(newStatement, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());
        msObject.setValue("sqlSource.boundSql.sql", sql);
        args[0] = newStatement;
    }

    /**
     * 获取新的MappedStatement
     *
     * @param ms
     * @param newSqlSource
     * @return
     */
    private MappedStatement newMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
        MappedStatement.Builder builder =
                new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());
        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        if (ms.getKeyProperties() != null && ms.getKeyProperties().length != 0) {
            StringBuilder keyProperties = new StringBuilder();
            for (String keyProperty : ms.getKeyProperties()) {
                keyProperties.append(keyProperty).append(",");
            }
            keyProperties.delete(keyProperties.length() - 1, keyProperties.length());
            builder.keyProperty(keyProperties.toString());
        }
        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());
        builder.resultMaps(ms.getResultMaps());
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());
        return builder.build();
    }

    @Override
    public Object plugin(Object o) {
        Object wrap = Plugin.wrap(o, this);
        return wrap;
    }

    @Override
    public void setProperties(Properties properties) {
    }

    /**
     * 新的SqlSource需要实现
     */
    class BoundSqlSqlSource implements SqlSource {
        private BoundSql boundSql;

        public BoundSqlSqlSource(BoundSql boundSql) {
            this.boundSql = boundSql;
        }

        @Override
        public BoundSql getBoundSql(Object parameterObject) {
            return boundSql;
        }
    }

    /**
     * 从参数列表返回PageRequest
     */
    public PageRequest getPageRequest(Object paramMap) {
        if (paramMap == null) {
            return null;
        } else if (PageRequest.class.isAssignableFrom(paramMap.getClass())) {
            return (PageRequest) paramMap;
        } else {
            if (paramMap instanceof MapperMethod.ParamMap) {
                MapperMethod.ParamMap map = (MapperMethod.ParamMap) paramMap;
                Iterator iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    Object obj = entry.getValue();
                    if (obj != null && PageRequest.class.isAssignableFrom(obj.getClass())) {
                        return (PageRequest) obj;
                    }
                }
            }
            return null;
        }
    }

    private Object getWhereParameter(Object obj) {
        if (obj instanceof MapperMethod.ParamMap) {
            MapperMethod.ParamMap paramMap = (MapperMethod.ParamMap) obj;
            if (paramMap.size() == 4) {
                Iterator iterator = paramMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry var4 = (Map.Entry) iterator.next();
                    Object var5 = var4.getValue();
                    if (Sort.class.isAssignableFrom(var5.getClass()) || PageRequest.class.isAssignableFrom(var5.getClass())) {
                        return paramMap.get("param1");
                    }
                }
            }
        }
        return obj;
    }
}
