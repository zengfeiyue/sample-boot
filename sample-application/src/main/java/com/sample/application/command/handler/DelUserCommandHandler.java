package com.sample.application.command.handler;

import com.sample.application.assembler.UserAssembler;
import com.sample.application.command.DelUserCmd;
import com.sample.ddd.core.cqrs.command.CommandHandler;
import com.sample.domain.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 创建用户
 *
 * @author laiqiao
 */
@Component
public class DelUserCommandHandler implements CommandHandler<DelUserCmd> {

    @Resource
    private UserRepository userRepository;

    @Override
    public void handle(DelUserCmd delUserCmd) {
        userRepository.delete(delUserCmd.getUserId());
    }
}
