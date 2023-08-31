package com.sample.domain.service;

import com.sample.domain.model.entity.UserEntity;

/**
 * 用户领域服务接口
 *
 * @author laiqiao
 */
public interface UserDomainService {

    /**
     * 创建用户
     * @param userEntity
     */
    void createUser(UserEntity userEntity);
}
