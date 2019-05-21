package com.satchain.commons.myEnum;

public enum TaskinfoDatadistrisignEnum {
    NOT_PUBLISH(0,"未发布"),
    PUBLISHED(1,"发布")
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

    TaskinfoDatadistrisignEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
