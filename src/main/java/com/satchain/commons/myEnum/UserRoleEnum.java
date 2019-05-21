package com.satchain.commons.myEnum;

/**
 * @author 董少飞
 * // TODO: 2019/5/19 dsf
 * @date 2019/5/19
 */
public enum UserRoleEnum {

    ADMIN(10, "管理员"),
    USER(11, "普通用户");

    public final Integer key;

    public final String value;

    UserRoleEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }
}
