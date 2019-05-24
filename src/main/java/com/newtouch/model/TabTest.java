package com.newtouch.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import javax.persistence.*;

@Table(name = "tab_test")
public class TabTest extends BaseRowModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 姓名
     */
    @ExcelProperty(index = 0)
    @Column(name = "t_name")
    private String tName;
    @Transient
    private String className;

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "TabTest{" +
                "id=" + id +
                ", tName='" + tName + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}