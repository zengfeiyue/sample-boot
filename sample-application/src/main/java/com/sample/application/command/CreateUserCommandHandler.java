package com.sample.application.command;

import com.sample.ddd.core.cqrs.command.CommandHandler;
import org.springframework.stereotype.Component;

/**
 * 创建用户
 *
 * @author laiqiao
 */
@Component
public class CreateUserCommandHandler implements CommandHandler<CreateUserCmd> {


    @Override
    public void handle(CreateUserCmd createUserCommand) {
        System.err.println(createUserCommand);
    }
}
