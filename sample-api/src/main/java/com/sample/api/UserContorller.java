package com.sample.api;

import com.sample.application.command.CreateUserCmd;
import com.sample.ddd.core.cqrs.command.CommandBus;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserContorller {

    @Resource
    private CommandBus commandBus;

    @PostMapping("/create")
    public void create(@RequestBody @Validated CreateUserCmd createUserCmd){
        commandBus.dispatch(createUserCmd);
    }
}
