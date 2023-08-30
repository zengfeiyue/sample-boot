package com.sample.domain.model.valueobject;

import lombok.Getter;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

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
        checkAccount(account);
        checkPassword(password);
        this.account = account;
        this.password = password;
        this.status = status;
    }



    private void checkAccount(String account) {
        Assert.hasText(account,"不能为空");
    }

    private void checkPassword(String password) {
        Assert.hasText(password,"不能为空");
    }
}
