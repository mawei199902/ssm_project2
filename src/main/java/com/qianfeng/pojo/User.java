package com.qianfeng.pojo;

public class User {
    /**
     * 用户id
     */
    private int userid;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 用户性别
     */
    private String usersex;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }
}
