package com.sample.domain.user.repository;


import com.sample.ddd.core.repository.Repository;
import com.sample.domain.user.model.AuthUser;

/**
 * 用户仓储
 *
 * @author zengfeiyue
 */
public interface UserRepository extends Repository<AuthUser,Integer> {

}
