package com.satchain.bean.vo;

import java.math.BigDecimal;

public class SatelliteInfoVO {

    private String satelliteId;//卫星编号

    private String nasaId;//NASA编号

    private String satelliteName;//卫星名称

    private String constellationId;//所属星座

    private Integer satelliteType;//卫星类型

    private String telemetryFre;//遥测频率

    private String telemetryErp;//遥测ERP值

    private String telecontrolFre;//遥控频率

    private String telecontrolGain;//遥控接收增益

    private String dataDownFre;//数据下行频率

    private String dataDownErp;//数据下行ERP值

    private String dataUpFre;//数据上行频率

    private String dataUpGain;//数据上行接收增益

    private String businessDownFre;//业务下行接收增益

    private String businessDownErp;//业务下行ERP值

    private String businessUpFre;//业务上行频率

    private String businessUpGain;//业务上行接收增益

    private BigDecimal dipAngle;//倾角

    private BigDecimal chek;//升交点赤径

    private Float eccentricity;//偏心率

    private Float semiMajorAxis;//半长轴

    private BigDecimal perigeeAngle;//近地点角距

    private String perigeeTime;//近地点时刻

    public String getSatelliteId() {
        return satelliteId;
    }

    public void setSatelliteId(String satelliteId) {
        this.satelliteId = satelliteId;
    }

    public String getNasaId() {
        return nasaId;
    }

    public void setNasaId(String nasaId) {
        this.nasaId = nasaId;
    }

    public String getSatelliteName() {
        return satelliteName;
    }

    public void setSatelliteName(String satelliteName) {
        this.satelliteName = satelliteName;
    }

    public String getConstellationId() {
        return constellationId;
    }

    public void setConstellationId(String constellationId) {
        this.constellationId = constellationId;
    }

    public Integer getSatelliteType() {
        return satelliteType;
    }

    public void setSatelliteType(Integer satelliteType) {
        this.satelliteType = satelliteType;
    }

    public String getTelemetryFre() {
        return telemetryFre;
    }

    public void setTelemetryFre(String telemetryFre) {
        this.telemetryFre = telemetryFre;
    }

    public String getTelemetryErp() {
        return telemetryErp;
    }

    public void setTelemetryErp(String telemetryErp) {
        this.telemetryErp = telemetryErp;
    }

    public String getTelecontrolFre() {
        return telecontrolFre;
    }

    public void setTelecontrolFre(String telecontrolFre) {
        this.telecontrolFre = telecontrolFre;
    }

    public String getTelecontrolGain() {
        return telecontrolGain;
    }

    public void setTelecontrolGain(String telecontrolGain) {
        this.telecontrolGain = telecontrolGain;
    }

    public String getDataDownFre() {
        return dataDownFre;
    }

    public void setDataDownFre(String dataDownFre) {
        this.dataDownFre = dataDownFre;
    }

    public String getDataDownErp() {
        return dataDownErp;
    }

    public void setDataDownErp(String dataDownErp) {
        this.dataDownErp = dataDownErp;
    }

    public String getDataUpFre() {
        return dataUpFre;
    }

    public void setDataUpFre(String dataUpFre) {
        this.dataUpFre = dataUpFre;
    }

    public String getDataUpGain() {
        return dataUpGain;
    }

    public void setDataUpGain(String dataUpGain) {
        this.dataUpGain = dataUpGain;
    }

    public String getBusinessDownFre() {
        return businessDownFre;
    }

    public void setBusinessDownFre(String businessDownFre) {
        this.businessDownFre = businessDownFre;
    }

    public String getBusinessDownErp() {
        return businessDownErp;
    }

    public void setBusinessDownErp(String businessDownErp) {
        this.businessDownErp = businessDownErp;
    }

    public String getBusinessUpFre() {
        return businessUpFre;
    }

    public void setBusinessUpFre(String businessUpFre) {
        this.businessUpFre = businessUpFre;
    }

    public String getBusinessUpGain() {
        return businessUpGain;
    }

    public void setBusinessUpGain(String businessUpGain) {
        this.businessUpGain = businessUpGain;
    }

    public BigDecimal getDipAngle() {
        return dipAngle;
    }

    public void setDipAngle(BigDecimal dipAngle) {
        this.dipAngle = dipAngle;
    }

    public BigDecimal getChek() {
        return chek;
    }

    public void setChek(BigDecimal chek) {
        this.chek = chek;
    }

    public Float getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Float eccentricity) {
        this.eccentricity = eccentricity;
    }

    public Float getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(Float semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public BigDecimal getPerigeeAngle() {
        return perigeeAngle;
    }

    public void setPerigeeAngle(BigDecimal perigeeAngle) {
        this.perigeeAngle = perigeeAngle;
    }

    public String getPerigeeTime() {
        return perigeeTime;
    }

    public void setPerigeeTime(String perigeeTime) {
        this.perigeeTime = perigeeTime;
    }
}
