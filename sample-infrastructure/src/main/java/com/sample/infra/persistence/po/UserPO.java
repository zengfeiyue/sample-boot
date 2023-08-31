package com.sample.infra.persistence.po;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

/**
 * 用户实体
 *
 * @author laiqiao
 */
@Entity
@Table(name = "auth_user")
public class UserPO implements Serializable {
    /**
     * 用户id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
     * nick_name
     */
    private String nickName;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态 1：启用 0禁用
     */
    private Integer status;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别 1男，2女
     */
    private Integer sex;

    /**
     * 头像
     */
    private String avatarUrl;

    private Integer createBy;

    private LocalTime createTime;

    private Integer updateBy;

    private LocalTime updateTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public LocalTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalTime createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public LocalTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalTime updateTime) {
        this.updateTime = updateTime;
    }
}
