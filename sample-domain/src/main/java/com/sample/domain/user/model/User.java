package com.sample.domain.user.model;

import com.sample.infra.ddd.AggregateRoot;
import com.sample.infra.model.po.user.UserPO;

import java.util.List;

/**
 * 用户聚合根
 *
 * @author laiqiao
 */
public class User extends UserPO implements AggregateRoot {

    /**
     *  角色集合
     */
    private List<Role> roles;



}
