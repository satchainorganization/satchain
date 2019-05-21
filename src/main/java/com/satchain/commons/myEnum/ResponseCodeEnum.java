package com.satchain.commons.myEnum;

/**
 * 定义响应的状态码
 */
public enum ResponseCodeEnum {
    SUCCESS(1,"成功"),
    ERROR(0,"失败"),
    // TODO: 2019/5/19 dsf
    PERMISSION_DENY(0, "无权限")
    ;

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ResponseCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
