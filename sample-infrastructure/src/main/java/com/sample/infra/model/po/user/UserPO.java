package com.sample.infra.model.po.user;

import java.io.Serializable;

/**
 * 用户实体
 *
 * @author laiqiao
 */
public class UserPO implements Serializable {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 账户
     */
    private String account;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 真是姓名
     */
    private String realName;
}
