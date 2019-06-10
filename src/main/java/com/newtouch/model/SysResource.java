package com.newtouch.model;

import javax.persistence.*;
import java.util.TreeSet;

@Table(name = "sys_resource")
public class SysResource  implements  Comparable{
    public SysResource() {
    }

    public SysResource(String resourceName, String resourceUrl, String resourceTitle) {
        this.resourceName = resourceName;
        this.resourceUrl = resourceUrl;
        this.resourceTitle = resourceTitle;
    }

    public SysResource(Integer resourceId, Integer parentId, String resourceName, String resourceUrl, String resourceTitle) {
        this.resourceId = resourceId;
        this.parentId = parentId;
        this.resourceName = resourceName;
        this.resourceUrl = resourceUrl;
        this.resourceTitle = resourceTitle;
    }

    public SysResource(Integer resourceId, String resourceName, String resourceUrl, String resourceTitle) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.resourceUrl = resourceUrl;
        this.resourceTitle = resourceTitle;
    }

    @Id
    @Column(name = "resource_id")
    private Integer resourceId;

    /**
     * 没有父类，parentid等于0
     */
    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "resource_url")
    private String resourceUrl;

    @Column(name = "resource_title")
    private String resourceTitle;

    @Transient
    private String longinName;

    @Transient
    private TreeSet<SysResource> childDate;
    /**
     * @return resource_id
     */
    public Integer getResourceId() {
        return resourceId;
    }

    /**
     * @param resourceId
     */
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 获取没有父类，parentid等于0
     *
     * @return parent_id - 没有父类，parentid等于0
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置没有父类，parentid等于0
     *
     * @param parentId 没有父类，parentid等于0
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return resource_name
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * @param resourceName
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * @return resource_url
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * @param resourceUrl
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    /**
     * @return resource_title
     */
    public String getResourceTitle() {
        return resourceTitle;
    }

    /**
     * @param resourceTitle
     */
    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }

    public String getLonginName() {
        return longinName;
    }

    public void setLonginName(String longinName) {
        this.longinName = longinName;
    }

    public TreeSet<SysResource> getChildDate() {
        return childDate;
    }

    public void setChildDate(TreeSet<SysResource> childDate) {
        this.childDate = childDate;
    }

    @Override
    public String toString() {
        return "SysResource{" +
                "resourceId=" + resourceId +
                ", parentId=" + parentId +
                ", resourceName='" + resourceName + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", resourceTitle='" + resourceTitle + '\'' +
                ", longinName='" + longinName + '\'' +
                ", childDate=" + childDate +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return -1;
    }
}