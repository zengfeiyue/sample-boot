package com.sample.infra.ddd;

import java.io.Serializable;

/**
 * 基础仓储接口
 *
 * @author zengfeiyue
 */
public interface Repository<E extends AggregateRoot, ID extends Serializable>{

    /**
     * 删除
     *
     * @param id
     */
    void delete(ID id);

    /**
     * 按id查找
     *
     * @param id
     * @return
     */
    E get(ID id);

    /**
     * 保存或更新聚合根
     *
     * @param aggregate
     * @param <S>
     * @return
     */
    <S extends E> S save(S aggregate);

}
