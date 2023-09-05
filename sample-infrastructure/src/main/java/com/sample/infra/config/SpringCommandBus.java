package com.sample.infra.config;

import com.sample.ddd.core.cqrs.command.Command;
import com.sample.ddd.core.cqrs.command.CommandBus;
import com.sample.ddd.core.cqrs.command.CommandHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
        CommandHandler<Command> handler = (CommandHandler<Command>) applicationContext.getBean(getHandlerBeanName(command));
        handler.handle(command);
    }

    /**
     * 根据命令类型返回对应的 bean 名称
     *
     * @param command
     * @return
     */
    private String getHandlerBeanName(Command command) {
        String commandType = command.getClass().getSimpleName();
        return StringUtils.uncapitalize(commandType) + "Handler";
    }
}
