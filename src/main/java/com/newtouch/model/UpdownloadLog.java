package com.newtouch.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "updownload_log")
public class UpdownloadLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 下载文件人
     */
    private String operater;

    /**
     * 文件名字
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * java类
     */
    @Column(name = "java_name")
    private String javaName;

    /**
     * java方法
     */
    @Column(name = "java_method")
    private String javaMethod;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 时间
     */
    private Date time;

    /**
     * 文件类型 1  上传  2 下载
     */
    @Column(name = "file_type")
    private String fileType;

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
     * 获取下载文件人
     *
     * @return operater - 下载文件人
     */
    public String getOperater() {
        return operater;
    }

    /**
     * 设置下载文件人
     *
     * @param operater 下载文件人
     */
    public void setOperater(String operater) {
        this.operater = operater;
    }

    /**
     * 获取文件名字
     *
     * @return file_name - 文件名字
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置文件名字
     *
     * @param fileName 文件名字
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取java类
     *
     * @return java_name - java类
     */
    public String getJavaName() {
        return javaName;
    }

    /**
     * 设置java类
     *
     * @param javaName java类
     */
    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }

    /**
     * 获取java方法
     *
     * @return java_method - java方法
     */
    public String getJavaMethod() {
        return javaMethod;
    }

    /**
     * 设置java方法
     *
     * @param javaMethod java方法
     */
    public void setJavaMethod(String javaMethod) {
        this.javaMethod = javaMethod;
    }

    /**
     * 获取ip地址
     *
     * @return ip - ip地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置ip地址
     *
     * @param ip ip地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取时间
     *
     * @return time - 时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置时间
     *
     * @param time 时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取文件类型 1  上传  2 下载
     *
     * @return file_type - 文件类型 1  上传  2 下载
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 设置文件类型 1  上传  2 下载
     *
     * @param fileType 文件类型 1  上传  2 下载
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}