package com.satchain.commons.result;

import com.satchain.commons.myEnum.ResponseCodeEnum;

import java.io.Serializable;

public class Result implements Serializable {
    private static final long serialVersionUID = -3948389268046368059L;
    private Integer code;
    private String message;
    private Object data;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result() {}

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Result success() {
        Result result = new Result();
        result.setCode(ResponseCodeEnum.SUCCESS.getCode());
        result.setMessage(ResponseCodeEnum.SUCCESS.getDesc());
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResponseCodeEnum.SUCCESS.getCode());
        result.setMessage(ResponseCodeEnum.SUCCESS.getDesc());
        result.setData(data);
        return result;
    }

    public static Result failure(ResponseCodeEnum resultCode) {
        Result result = new Result();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getDesc());
        return result;
    }

    public static Result failure(ResponseCodeEnum resultCode, Object data) {
        Result result = new Result();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getDesc());
        result.setData(data);
        return result;
    }
}
