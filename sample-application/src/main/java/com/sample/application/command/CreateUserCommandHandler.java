package com.sample.application.command;

import com.sample.application.assembler.UserAssembler;
import com.sample.ddd.core.cqrs.command.CommandHandler;
import com.sample.domain.model.entity.UserEntity;
import com.sample.domain.repository.UserRepository;
import com.sample.domain.service.UserDomainService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 创建用户
 *
 * @author laiqiao
 */
@Component
public class CreateUserCommandHandler implements CommandHandler<CreateUserCmd> {

    @Resource
    private UserDomainService userDomainService;

    @Override
    public void handle(CreateUserCmd createUserCommand) {
        UserEntity userEntity = UserAssembler.INSTANCE.toEntity(createUserCommand);
        userDomainService.createUser(userEntity);
    }
}
