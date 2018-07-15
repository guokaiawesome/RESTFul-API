package com.monster.demo.pojo.po.user;

import java.util.Date;

public class UserBaseInfo {
    private Long id;

    private String uid;

    private String realName;

    private String nickName;

    private Date gmtCreate;

    private Date gmtModified;

    public UserBaseInfo(Long id, String uid, String realName, String nickName, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.uid = uid;
        this.realName = realName;
        this.nickName = nickName;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UserBaseInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
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