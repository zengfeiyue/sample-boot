package com.sample.application.command;

import com.sample.application.assembler.UserAssembler;
import com.sample.domain.model.entity.AuthUser;

/**
 * 创建用户
 *
 * @author laiqiao
 */
public class CreateUserCommand {

    private String name;

    public CreateUserCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        CreateUserCommand createUserCommand = new CreateUserCommand("zfy");
        AuthUser authUser = UserAssembler.INSTANCE.toUser(createUserCommand);
        System.err.println(authUser.getAccount().getAccount());
    }
}
