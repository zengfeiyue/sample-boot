package com.sample.controller;

import com.sample.mapper.sys.UserMapper;
import com.sample.model.sys.User;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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

    @GetMapping("/v2")
    public Page<User> test2(Pageable pageable){

        return new PageImpl<User>(null);
    }
}
