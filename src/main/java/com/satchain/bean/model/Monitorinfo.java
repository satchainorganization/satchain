package com.satchain.bean.model;

/**
 * 系统日志表
 */
public class Monitorinfo {
    private Long id;

    private String monitorPosition;//监控器位置

    private String monitorUuid;//监控器编号

    private String monitorIp;//监控器连接地址

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonitorPosition() {
        return monitorPosition;
    }

    public void setMonitorPosition(String monitorPosition) {
        this.monitorPosition = monitorPosition;
    }

    public String getMonitorUuid() {
        return monitorUuid;
    }

    public void setMonitorUuid(String monitorUuid) {
        this.monitorUuid = monitorUuid;
    }

    public String getMonitorIp() {
        return monitorIp;
    }

    public void setMonitorIp(String monitorIp) {
        this.monitorIp = monitorIp;
    }
}