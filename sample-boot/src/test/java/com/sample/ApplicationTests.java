package com.sample;

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

    }
}
