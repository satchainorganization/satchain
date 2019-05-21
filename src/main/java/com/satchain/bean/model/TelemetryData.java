package com.satchain.bean.model;

import java.util.Date;

public class TelemetryData {
    private Long id;

    private Long deviceRelationId;

    private Date time;

    private Float temperature;

    private Float voltage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeviceRelationId() {
        return deviceRelationId;
    }

    public void setDeviceRelationId(Long deviceRelationId) {
        this.deviceRelationId = deviceRelationId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getVoltage() {
        return voltage;
    }

    public void setVoltage(Float voltage) {
        this.voltage = voltage;
    }
}