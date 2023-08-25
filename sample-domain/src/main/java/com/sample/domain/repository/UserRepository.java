package com.sample.domain.repository;


import com.sample.ddd.core.repository.Repository;
import com.sample.domain.model.entity.AuthUser;

/**
 * 用户仓储
 *
 * @author zengfeiyue
 */
public interface UserRepository extends Repository<AuthUser,Integer> {

}
