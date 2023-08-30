package com.sample.application.service.impl;

import com.sample.application.assembler.UserAssembler;
import com.sample.application.service.UserAppService;
import com.sample.domain.model.entity.UserEntity;
import com.sample.domain.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
        UserEntity user = UserAssembler.INSTANCE.toEntity(null);

    }

    @Override
    public void deleteUser() {

    }
}
