package com.sample.domain.user.model;

import com.sample.ddd.core.entity.AggregateRoot;
import com.sample.domain.user.model.valueobject.*;

import java.util.List;


/**
 * 用户聚合根
 *
 * @author laiqiao
 */
public class AuthUser implements AggregateRoot {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 账号信息
     */
    private UserAccount account;

    /**
     * 头像
     */
    private UserInfo userInfo;

    /**
     *  角色集合
     */
    private List<Role> roles;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserAccount getAccount() {
        return account;
    }

    public void setAccount(UserAccount account) {
        this.account = account;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
