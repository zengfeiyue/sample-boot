package com.sample.application.service.impl;

import com.sample.application.service.UserAppService;
import com.sample.domain.user.model.AuthUser;
import com.sample.domain.user.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 用户服务
 *
 * @author zengfeiyue
 */
@Service
public class UserAppServiceImpl implements UserAppService {

    @Resource
    private UserRepository userRepository;

    @Override
    public void createUser() {
        AuthUser byId = userRepository.getById(1);
        Assert.notNull(byId,"用户已存在");
    }

    @Override
    public void deleteUser() {

    }
}
