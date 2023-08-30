package com.sample.domain.model.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.Assert;

/**
 * 用户基本信息
 *
 * @author laiqiao
 */
@Getter
public class UserInfo {

    /**
     * 姓名
     */
    private String userName;

    /**
     * nick_name
     */
    private String nickName;

    /**
     * 性别 1男，2女
     */
    private Integer sex;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String avatarUrl;

    public UserInfo(String userName, String nickName, Integer sex, String phone, String avatarUrl) {
        checkUserName(userName);
        this.userName = userName;
        this.nickName = nickName;
        this.sex = sex;
        this.phone = phone;
        this.avatarUrl = avatarUrl;
    }

    private void checkUserName(String userName) {
        Assert.hasText(userName,"用户名不能为空！");
    }
}
