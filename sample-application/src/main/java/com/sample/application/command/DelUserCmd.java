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
public class DelUserCmd implements Command {

    /**
     * 用户id
     */
    private Integer userId;

}
