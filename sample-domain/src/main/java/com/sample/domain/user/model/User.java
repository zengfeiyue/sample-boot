package com.sample.domain.user.model;

import com.sample.ddd.core.entity.AggregateRoot;

import java.util.List;

/**
 * 用户聚合根
 *
 * @author laiqiao
 */
public class User implements AggregateRoot {

    /**
     *  角色集合
     */
    private List<Role> roles;



}
