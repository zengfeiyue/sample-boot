package com.sample.api;

import com.sample.api.cmd.CreateUserCmd;
import com.sample.application.service.impl.UserAppService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserContorller {

    @Resource
    private UserAppService userAppService;

    @GetMapping("/create")
    public void create(@RequestBody CreateUserCmd createUserCmd){
        System.err.println(userAppService);
    }
}
