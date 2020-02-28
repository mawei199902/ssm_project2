package com.qianfeng.pojo;

/**
 * 登录用户名
 */
public class LoginUser {
    /**
     * 登录用户id
     */
    private int login_user_id;
    /**
     * 登录用户名
     */
    private String login_user_name;

    public int getLogin_user_id() {
        return login_user_id;
    }

    public void setLogin_user_id(int login_user_id) {
        this.login_user_id = login_user_id;
    }

    public String getLogin_user_name() {
        return login_user_name;
    }

    public void setLogin_user_name(String login_user_name) {
        this.login_user_name = login_user_name;
    }
}
