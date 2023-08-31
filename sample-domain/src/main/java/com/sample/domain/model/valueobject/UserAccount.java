package com.sample.domain.model.valueobject;

import lombok.Getter;
import org.springframework.util.Assert;

/**
 * 用户账号信息
 *
 * @author laiqiao
 */
@Getter
public class UserAccount {

    /**
     * 账户
     */

    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     */
    private Integer status;

    public UserAccount(String account, String password, Integer status) {
        this.account = account;
        this.password = password;
        this.status = status;
    }
}
