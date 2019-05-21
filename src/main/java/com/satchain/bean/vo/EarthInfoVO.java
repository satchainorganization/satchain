package com.satchain.bean.vo;

import java.math.BigDecimal;

public class EarthInfoVO {
    private String groundId;//地面站编号

    private String groundName;//地面站名称

    private Integer groundType;//地面站类型

    private String groundTelemetryFre;//地面站遥测频率

    private String groundTelemetryGain;//站遥测增益

    private String groundTelecontrolFre;//地面站遥控频率

    private String groundTelecontrolErp;//`地面站遥控ERP值`

    private String dataDownFre;//数据下行频率

    private String dataDownGain;//数据下行增益

    private String dataUpFre;//数据上行频率

    private String dataUpErp;//数据上行ERP值

    private BigDecimal lon;//经度

    private BigDecimal lat;//纬度

    private String ip;//IP地址

    public String getGroundId() {
        return groundId;
    }

    public void setGroundId(String groundId) {
        this.groundId = groundId;
    }

    public String getGroundName() {
        return groundName;
    }

    public void setGroundName(String groundName) {
        this.groundName = groundName;
    }

    public Integer getGroundType() {
        return groundType;
    }

    public void setGroundType(Integer groundType) {
        this.groundType = groundType;
    }

    public String getGroundTelemetryFre() {
        return groundTelemetryFre;
    }

    public void setGroundTelemetryFre(String groundTelemetryFre) {
        this.groundTelemetryFre = groundTelemetryFre;
    }

    public String getGroundTelemetryGain() {
        return groundTelemetryGain;
    }

    public void setGroundTelemetryGain(String groundTelemetryGain) {
        this.groundTelemetryGain = groundTelemetryGain;
    }

    public String getGroundTelecontrolFre() {
        return groundTelecontrolFre;
    }

    public void setGroundTelecontrolFre(String groundTelecontrolFre) {
        this.groundTelecontrolFre = groundTelecontrolFre;
    }

    public String getGroundTelecontrolErp() {
        return groundTelecontrolErp;
    }

    public void setGroundTelecontrolErp(String groundTelecontrolErp) {
        this.groundTelecontrolErp = groundTelecontrolErp;
    }

    public String getDataDownFre() {
        return dataDownFre;
    }

    public void setDataDownFre(String dataDownFre) {
        this.dataDownFre = dataDownFre;
    }

    public String getDataDownGain() {
        return dataDownGain;
    }

    public void setDataDownGain(String dataDownGain) {
        this.dataDownGain = dataDownGain;
    }

    public String getDataUpFre() {
        return dataUpFre;
    }

    public void setDataUpFre(String dataUpFre) {
        this.dataUpFre = dataUpFre;
    }

    public String getDataUpErp() {
        return dataUpErp;
    }

    public void setDataUpErp(String dataUpErp) {
        this.dataUpErp = dataUpErp;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
