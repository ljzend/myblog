package com.ljz.myblog_admin.vo;

/**
 * @ClassName : LoginParam
 * @Description :
 * @Author : ljz
 * @Date: 2022/7/15  19:03
 */

public class LoginParamVo {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginParamVo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginParamVo() {
    }

    @Override
    public String toString() {
        return "LoginParamVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
