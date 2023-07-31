package com.sample.domain.user.model;

import com.sample.infra.po.user.UserPO;

import java.util.List;

/**
 * 用户聚合根
 *
 * @author laiqiao
 */
public class User extends UserPO {

    /**
     *  角色集合
     */
    private List<Role> roles;



}
