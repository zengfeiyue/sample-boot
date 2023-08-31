package com.sample.infra.persistence.po;

import com.sample.domain.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 用户转换器
 *
 * @author laiqiao
 */
@Mapper
public interface UserPOAssembler {
    UserPOAssembler INSTANCE = Mappers.getMapper(UserPOAssembler.class);

    /**
     * 命令转换层实体
     *
     * @param userEntity
     * @return
     */
    @Mappings({
            @Mapping(source = "account.account", target = "account"),
            @Mapping(source = "account.password", target = "password"),
            @Mapping(source = "userInfo.userName", target = "userName"),
            @Mapping(source = "userInfo.nickName", target = "nickName"),
    })
    UserPO toPo(UserEntity userEntity);

    @Mappings({
            @Mapping(source = "account", target = "account.account"),
            @Mapping(source = "password", target = "account.password"),
            @Mapping(source = "userName", target = "userInfo.userName"),
            @Mapping(source = "nickName", target = "userInfo.nickName"),
    })
    UserEntity toEntity(UserPO UserPO);


}
