package com.sample.application.command;

import com.sample.ddd.core.cqrs.command.CommandHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author laiqiao
 */
@Component
public class CreateOrderCommandHandler implements CommandHandler<CreateUserCommand> {
    @Override
    public void handle(CreateUserCommand createUserCommand) {
        System.err.println(createUserCommand);
    }
}
