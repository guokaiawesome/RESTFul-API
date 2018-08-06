package com.monster.demo.pojo.po.employee;

import java.time.LocalDateTime;

public class EmployeeSensitiveInfo {
    private Long id;

    private String idCardNoEncrypt;

    private String phoneNoEncrypt;

    private String emailEncrypt;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdCardNoEncrypt() {
        return idCardNoEncrypt;
    }

    public void setIdCardNoEncrypt(String idCardNoEncrypt) {
        this.idCardNoEncrypt = idCardNoEncrypt == null ? null : idCardNoEncrypt.trim();
    }

    public String getPhoneNoEncrypt() {
        return phoneNoEncrypt;
    }

    public void setPhoneNoEncrypt(String phoneNoEncrypt) {
        this.phoneNoEncrypt = phoneNoEncrypt == null ? null : phoneNoEncrypt.trim();
    }

    public String getEmailEncrypt() {
        return emailEncrypt;
    }

    public void setEmailEncrypt(String emailEncrypt) {
        this.emailEncrypt = emailEncrypt == null ? null : emailEncrypt.trim();
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }
}