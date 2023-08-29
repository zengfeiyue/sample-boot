package com.sample.domain.model.entity;

import com.sample.ddd.core.entity.AggregateRoot;
import com.sample.domain.model.valueobject.UserAccount;
import com.sample.domain.model.valueobject.UserInfo;
import lombok.Getter;

import java.util.List;


/**
 * 用户聚合根
 *
 * @author laiqiao
 */
@Getter
public class User implements AggregateRoot {
    /**
     * 用户id
     */
    private Integer userId;

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
    private List<Role> roles;


}
