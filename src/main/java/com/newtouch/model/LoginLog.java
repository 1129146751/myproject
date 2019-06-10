package com.newtouch.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "login_log")
public class LoginLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 登录人
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 登录的电脑ip地址
     */
    @Column(name = "user_ip")
    private String userIp;

    /**
     * 登录时间
     */
    private Date tiime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取登录人
     *
     * @return user_name - 登录人
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置登录人
     *
     * @param userName 登录人
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取登录的电脑ip地址
     *
     * @return user_ip - 登录的电脑ip地址
     */
    public String getUserIp() {
        return userIp;
    }

    /**
     * 设置登录的电脑ip地址
     *
     * @param userIp 登录的电脑ip地址
     */
    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    /**
     * 获取登录时间
     *
     * @return tiime - 登录时间
     */
    public Date getTiime() {
        return tiime;
    }

    /**
     * 设置登录时间
     *
     * @param tiime 登录时间
     */
    public void setTiime(Date tiime) {
        this.tiime = tiime;
    }
}