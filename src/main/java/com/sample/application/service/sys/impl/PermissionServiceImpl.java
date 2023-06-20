package com.sample.application.service.sys.impl;

import com.sample.application.service.sys.PermissionService;
import com.sample.domain.repository.PermissionMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

}
