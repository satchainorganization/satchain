package com.satchain.bean.model;

public class DeviceRelation {
    private Long id;

    private String deviceName;//设备名

    private String deviceFartherName;//父设备名

    private String moonNum;//卫星编号

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceFartherName() {
        return deviceFartherName;
    }

    public void setDeviceFartherName(String deviceFartherName) {
        this.deviceFartherName = deviceFartherName;
    }

    public String getMoonNum() {
        return moonNum;
    }

    public void setMoonNum(String moonNum) {
        this.moonNum = moonNum;
    }
}