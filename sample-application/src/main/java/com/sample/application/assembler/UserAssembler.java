package com.sample.application.assembler;

import com.sample.application.dto.command.CreateUserCommand;
import com.sample.domain.user.model.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserAssembler{
    UserAssembler INSTANCE = Mappers.getMapper(UserAssembler.class);
    @Mappings({
            @Mapping(source = "name", target = "account.account"),
    })
    AuthUser toUser(CreateUserCommand createUserCommand);


}