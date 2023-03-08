package com.sample.controller;

import com.sample.dao.UserMapper;
import com.sample.model.SysUser;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/test")
public class TestController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/v1")
    public Page<SysUser> test(Pageable pageable){
        return userMapper.selectAll(pageable);
    }
}
