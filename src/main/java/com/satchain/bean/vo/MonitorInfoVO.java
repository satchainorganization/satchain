package com.satchain.bean.vo;

public class MonitorInfoVO {

    private String monitorStation;//监控器位置

    private String monitorid;//监控器编号

    private String monitorUri;//监控器连接地址

    public String getMonitorStation() {
        return monitorStation;
    }

    public void setMonitorStation(String monitorStation) {
        this.monitorStation = monitorStation;
    }

    public String getMonitorid() {
        return monitorid;
    }

    public void setMonitorid(String monitorid) {
        this.monitorid = monitorid;
    }

    public String getMonitorUri() {
        return monitorUri;
    }

    public void setMonitorUri(String monitorUri) {
        this.monitorUri = monitorUri;
    }
}
