package com.songtech.model;

import javax.persistence.*;

@Table(name = "tab_test")
public class TabTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 姓名
     */
    @Column(name = "t_name")
    private String tName;

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
     * 获取姓名
     *
     * @return t_name - 姓名
     */
    public String gettName() {
        return tName;
    }

    /**
     * 设置姓名
     *
     * @param tName 姓名
     */
    public void settName(String tName) {
        this.tName = tName;
    }
}