package com.newtouch.model;

import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户登陆名
     */
    @Column(name = "user_longin_name")
    private String userLonginName;

    /**
     * 用户系统名
     */
    @Column(name = "user_sys_name")
    private String userSysName;

    /**
     * 用户密码
     */
    @Column(name = "user_password")
    private String userPassword;

    /**
     * 是否锁定 1是 0否
     */
    @Column(name = "user_lock")
    private String userLock;

    /**
     * 错误次数 达到5次 自动锁定
     */
    @Column(name = "user_error_times")
    private Integer userErrorTimes;

    /**
     * 加密盐
     */
    @Column(name = "user_salt")
    private String userSalt;

    /**
     * 用户是否启用 1启用
     */
    private Integer state;

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户登陆名
     *
     * @return user_longin_name - 用户登陆名
     */
    public String getUserLonginName() {
        return userLonginName;
    }

    /**
     * 设置用户登陆名
     *
     * @param userLonginName 用户登陆名
     */
    public void setUserLonginName(String userLonginName) {
        this.userLonginName = userLonginName;
    }

    /**
     * 获取用户系统名
     *
     * @return user_sys_name - 用户系统名
     */
    public String getUserSysName() {
        return userSysName;
    }

    /**
     * 设置用户系统名
     *
     * @param userSysName 用户系统名
     */
    public void setUserSysName(String userSysName) {
        this.userSysName = userSysName;
    }

    /**
     * 获取用户密码
     *
     * @return user_password - 用户密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置用户密码
     *
     * @param userPassword 用户密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * 获取是否锁定 1是 0否
     *
     * @return user_lock - 是否锁定 1是 0否
     */
    public String getUserLock() {
        return userLock;
    }

    /**
     * 设置是否锁定 1是 0否
     *
     * @param userLock 是否锁定 1是 0否
     */
    public void setUserLock(String userLock) {
        this.userLock = userLock;
    }

    /**
     * 获取错误次数 达到5次 自动锁定
     *
     * @return user_error_times - 错误次数 达到5次 自动锁定
     */
    public Integer getUserErrorTimes() {
        return userErrorTimes;
    }

    /**
     * 设置错误次数 达到5次 自动锁定
     *
     * @param userErrorTimes 错误次数 达到5次 自动锁定
     */
    public void setUserErrorTimes(Integer userErrorTimes) {
        this.userErrorTimes = userErrorTimes;
    }

    /**
     * 获取加密盐
     *
     * @return user_salt - 加密盐
     */
    public String getUserSalt() {
        return userSalt;
    }

    /**
     * 设置加密盐
     *
     * @param userSalt 加密盐
     */
    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    /**
     * 获取用户是否启用 1启用
     *
     * @return state - 用户是否启用 1启用
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置用户是否启用 1启用
     *
     * @param state 用户是否启用 1启用
     */
    public void setState(Integer state) {
        this.state = state;
    }
}