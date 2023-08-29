package com.sample.application.service.impl;

import com.sample.application.assembler.UserAssembler;
import com.sample.application.service.UserAppService;
import com.sample.domain.model.entity.User;
import com.sample.domain.repository.UserRepository;
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
        User user = UserAssembler.INSTANCE.toUser(null);

    }

    @Override
    public void deleteUser() {

    }
}
