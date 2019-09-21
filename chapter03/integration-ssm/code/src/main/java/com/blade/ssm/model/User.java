package com.blade.ssm.model;

import org.springframework.stereotype.Component;

@Component
public class User {

    private long userId;
    private String userName;
    private String userPassword;
    private String userSex;
    private String userPhone;
    private String userEmail;
    private long userRank;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp loginTime;

    public User() {

    }

    @Override
    public String toString() {
        return "User Id Is: " + this.userId;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }


    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    public long getUserRank() {
        return userRank;
    }

    public void setUserRank(long userRank) {
        this.userRank = userRank;
    }


    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }


    public java.sql.Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(java.sql.Timestamp loginTime) {
        this.loginTime = loginTime;
    }

}
