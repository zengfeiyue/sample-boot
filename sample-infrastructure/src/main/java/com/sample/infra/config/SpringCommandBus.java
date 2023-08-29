package com.sample.infra.config;

import com.sample.ddd.core.cqrs.command.Command;
import com.sample.ddd.core.cqrs.command.CommandBus;
import com.sample.ddd.core.cqrs.command.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 命令总线
 * @author laiqiao
 */
@Component
public class SpringCommandBus implements CommandBus {
    private final ApplicationContext applicationContext;

    public SpringCommandBus(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void dispatch(Command command) {
        CommandHandler<Command> handler = applicationContext.getBean(CommandHandler.class);
        handler.handle(command);
    }
}
