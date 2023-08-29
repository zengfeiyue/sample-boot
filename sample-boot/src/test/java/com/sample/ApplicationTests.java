package com.sample;

import com.sample.application.command.CreateUserCommand;
import com.sample.boot.SampleBootlication;
import com.sample.ddd.core.cqrs.command.CommandBus;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SampleBootlication.class)
public class ApplicationTests {

    @Resource
    private CommandBus commandBus;
    @Test
    public void test(){
        commandBus.dispatch(new CreateUserCommand(null));
    }
}
