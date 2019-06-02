package com.satchain.commons.myEnum;

public enum LoginEnum {
    LOGIN_USER(12000, "用户登陆系统"),
    EXIT_USER(12001, "用户退出系统");

    public final Integer key;
    public final String value;
    LoginEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
