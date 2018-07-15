package com.monster.demo.pojo.po.employee;

import java.util.Date;

public class EmployeeBaseInfo {
    private Long id;

    private String realName;

    private String nickName;

    private Date gmtCreate;

    private Date gmtModified;

    public EmployeeBaseInfo(Long id, String realName, String nickName, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.realName = realName;
        this.nickName = nickName;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public EmployeeBaseInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}