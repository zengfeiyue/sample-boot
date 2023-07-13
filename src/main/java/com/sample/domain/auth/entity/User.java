package com.sample.domain.auth.entity;

import com.sample.domain.auth.entity.valueobject.RoleId;
import com.sample.domain.auth.entity.valueobject.UserId;
import com.sample.domain.auth.repository.UserRepository;

import java.util.List;

/**
 * 用户领域
 *
 * @author zengfeiyue
 */
public class User {

    /**
     * 用户id
     */
    private UserId id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 简称
     */
    private String nickName;

    /**
     * 角色集合
     */
    private List<RoleId> roles;

    private UserRepository userRepository;

    public void load(){

    }

    public void loadRole(){

    }

    public void authRole(List<RoleId> roles){

    }
}
