package com.sample.application.command;

import com.sample.ddd.core.cqrs.command.Command;
import com.sample.domain.model.valueobject.RoleValue;
import com.sample.domain.model.valueobject.UserAccount;
import com.sample.domain.model.valueobject.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * 创建用户
 *
 * @author laiqiao
 */
@AllArgsConstructor
@Getter
public class CreateUserCmd implements Command {

    /**
     * 用户账号信息
     */
    private UserAccount account;

    /**
     * 用户信息
     */
    private UserInfo userInfo;

    /**
     *  角色集合
     */
    private List<RoleValue> roles;

}
