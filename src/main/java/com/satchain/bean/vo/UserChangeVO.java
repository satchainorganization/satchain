package com.satchain.bean.vo;

public class UserChangeVO {
    private String username;//用户名
    private String newpassword;//密码
    private Integer newpermission;//用户权限：1-管理员，2-普通用户

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public Integer getNewpermission() {
        return newpermission;
    }

    public void setNewpermission(Integer newpermission) {
        this.newpermission = newpermission;
    }
}
