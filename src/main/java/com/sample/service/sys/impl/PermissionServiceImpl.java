package com.sample.service.sys.impl;

import com.sample.mapper.sys.PermissionMapper;
import com.sample.service.sys.PermissionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

}
