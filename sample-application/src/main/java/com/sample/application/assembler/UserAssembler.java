package com.sample.application.assembler;

import com.sample.application.command.CreateUserCmd;
import com.sample.domain.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户转换器
 * @author laiqiao
 */
@Mapper
public interface UserAssembler {
    UserAssembler INSTANCE = Mappers.getMapper(UserAssembler.class);

    /**
     * 命令转换层实体
     *
     * @param createUserCmd
     * @return
     */
    UserEntity toEntity(CreateUserCmd createUserCmd);


}
