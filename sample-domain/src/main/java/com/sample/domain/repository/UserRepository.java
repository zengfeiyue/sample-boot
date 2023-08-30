package com.sample.domain.repository;


import com.sample.ddd.core.ddd.repository.Repository;
import com.sample.domain.model.entity.UserEntity;

/**
 * 用户仓储
 *
 * @author zengfeiyue
 */
public interface UserRepository extends Repository<UserEntity,Integer> {

}
