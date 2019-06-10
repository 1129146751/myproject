package com.newtouch.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import org.springframework.stereotype.Component;

import java.util.Date;
import javax.persistence.*;
@Component
@Table(name = "tab_teacher")
public class TabTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Excel(name="姓名",orderNum ="0")
    @Column(name = "teacher_name")
    private String teacherName;
    @Excel(name="性别",orderNum ="1")
    @Column(name = "teacher_sex")
    private String teacherSex;
    @Excel(name="课程",orderNum ="2")
    @Column(name = "teacher_course")
    private String teacherCourse;

    @Column(name = "create_time")
    private Date createTime;

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
     * @return teacher_name
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * @return teacher_sex
     */
    public String getTeacherSex() {
        return teacherSex;
    }

    /**
     * @param teacherSex
     */
    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    /**
     * @return teacher_course
     */
    public String getTeacherCourse() {
        return teacherCourse;
    }

    /**
     * @param teacherCourse
     */
    public void setTeacherCourse(String teacherCourse) {
        this.teacherCourse = teacherCourse;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}