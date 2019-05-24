package com.satchain.bean.vo;

import java.io.Serializable;

public class LogInfoVO implements Serializable {

    private String time;//日志产生时间

    private String module;//产生日志的模块

    private String event;//具体事件

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
