package com.newtouch.model;

import javax.persistence.*;

@Table(name = "shiro_confige")
public class ShiroConfige {
    @Id
    private String url;

    private String roles;

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return roles
     */
    public String getRoles() {
        return roles;
    }

    /**
     * @param roles
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }
}