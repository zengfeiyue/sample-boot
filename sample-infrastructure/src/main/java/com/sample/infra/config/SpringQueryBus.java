package com.sample.infra.config;

import com.sample.ddd.core.cqrs.query.Query;
import com.sample.ddd.core.cqrs.query.QueryBus;
import com.sample.ddd.core.cqrs.query.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 查询总线
 *
 * @author laiqiao
 */
@Component
public class SpringQueryBus implements QueryBus {

    private final ApplicationContext applicationContext;

    public SpringQueryBus(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public <R> R dispatch(Query<R> query) {
        QueryHandler<Query<R>, R> handler = applicationContext.getBean(QueryHandler.class);
        return handler.handle(query);
    }
}
