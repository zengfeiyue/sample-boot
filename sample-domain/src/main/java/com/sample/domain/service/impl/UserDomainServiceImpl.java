package com.sample.domain.service.impl;

import com.sample.domain.model.entity.UserEntity;
import com.sample.domain.repository.UserRepository;
import com.sample.domain.service.UserDomainService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * 用户领域服务
 *
 * @author zengfeiyue
 */
@Component
public class UserDomainServiceImpl implements UserDomainService {

    @Resource
    private UserRepository userRepository;

    @Override
    public void createUser(UserEntity userEntity) {
        String account = userEntity.getAccount().getAccount();
        UserEntity byAccount=userRepository.findByAccount(account);
        Assert.isNull(byAccount,"创建失败，账号已存在！");
        userRepository.save(userEntity);
    }
}
