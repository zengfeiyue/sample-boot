package com.sample.controller;

import com.sample.dao.UserMapper;
import com.sample.model.sys.User;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class TestController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/v1")
    public Page<User> test(Pageable pageable){
        return userMapper.selectAll(pageable);
    }
}
