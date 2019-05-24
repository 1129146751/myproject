package com.newtouch.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_attach")
public class SysAttach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "file_old_name")
    private String fileOldName;

    @Column(name = "file_sys_name")
    private String fileSysName;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "operate_user")
    private String operateUser;

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
     * @return file_old_name
     */
    public String getFileOldName() {
        return fileOldName;
    }

    /**
     * @param fileOldName
     */
    public void setFileOldName(String fileOldName) {
        this.fileOldName = fileOldName;
    }

    /**
     * @return file_sys_name
     */
    public String getFileSysName() {
        return fileSysName;
    }

    /**
     * @param fileSysName
     */
    public void setFileSysName(String fileSysName) {
        this.fileSysName = fileSysName;
    }

    /**
     * @return file_path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return operate_user
     */
    public String getOperateUser() {
        return operateUser;
    }

    /**
     * @param operateUser
     */
    public void setOperateUser(String operateUser) {
        this.operateUser = operateUser;
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