package com.satchain.bean.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 卫星信息表
 */
public class Satelliteinfo {
    private Long id;

    private String satelliteUuid;//卫星编号

    private String nasaUuid;//NASA编号

    private String satelliteName;//卫星名称

    private String constellationType;//所属星座

    private Integer satelliteType;//卫星类型

    private String telemetryFrequency;//遥测频率

    private String telemetryErp;//遥测ERP值

    private String telecontrolFrequency;//遥控频率

    private String telecontrolReceivingGain;//遥控接收增益

    private String dataDownlinkFrequency;//数据下行频率

    private String dataDownlinkErp;//数据下行ERP值

    private String dataUplinkFrequency;//数据上行频率

    private String dataUplinkReceivingGain;//数据上行接收增益

    private String businessDownlinkFrequency;//业务下行频率

    private String businessDownlinkErp;//业务下行ERP值

    private String businessUplinkFrequency;//业务上行频率

    private String businessUplinkReceivingGain;//业务上行接收增益

    private BigDecimal dipAngle;//倾角

    private BigDecimal equatorialRadius;//升交点赤径

    private Float eccentricity;//偏心率

    private Float majorSemiaxis;//半长轴

    private BigDecimal perigeeAngularDistance;//近地点角距

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date perigeeMoment;//近地点时刻

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSatelliteUuid() {
        return satelliteUuid;
    }

    public void setSatelliteUuid(String satelliteUuid) {
        this.satelliteUuid = satelliteUuid;
    }

    public String getNasaUuid() {
        return nasaUuid;
    }

    public void setNasaUuid(String nasaUuid) {
        this.nasaUuid = nasaUuid;
    }

    public String getSatelliteName() {
        return satelliteName;
    }

    public void setSatelliteName(String satelliteName) {
        this.satelliteName = satelliteName;
    }

    public String getConstellationType() {
        return constellationType;
    }

    public void setConstellationType(String constellationType) {
        this.constellationType = constellationType;
    }

    public Integer getSatelliteType() {
        return satelliteType;
    }

    public void setSatelliteType(Integer satelliteType) {
        this.satelliteType = satelliteType;
    }

    public String getTelemetryFrequency() {
        return telemetryFrequency;
    }

    public void setTelemetryFrequency(String telemetryFrequency) {
        this.telemetryFrequency = telemetryFrequency;
    }

    public String getTelemetryErp() {
        return telemetryErp;
    }

    public void setTelemetryErp(String telemetryErp) {
        this.telemetryErp = telemetryErp;
    }

    public String getTelecontrolFrequency() {
        return telecontrolFrequency;
    }

    public void setTelecontrolFrequency(String telecontrolFrequency) {
        this.telecontrolFrequency = telecontrolFrequency;
    }

    public String getTelecontrolReceivingGain() {
        return telecontrolReceivingGain;
    }

    public void setTelecontrolReceivingGain(String telecontrolReceivingGain) {
        this.telecontrolReceivingGain = telecontrolReceivingGain;
    }

    public String getDataDownlinkFrequency() {
        return dataDownlinkFrequency;
    }

    public void setDataDownlinkFrequency(String dataDownlinkFrequency) {
        this.dataDownlinkFrequency = dataDownlinkFrequency;
    }

    public String getDataDownlinkErp() {
        return dataDownlinkErp;
    }

    public void setDataDownlinkErp(String dataDownlinkErp) {
        this.dataDownlinkErp = dataDownlinkErp;
    }

    public String getDataUplinkFrequency() {
        return dataUplinkFrequency;
    }

    public void setDataUplinkFrequency(String dataUplinkFrequency) {
        this.dataUplinkFrequency = dataUplinkFrequency;
    }

    public String getDataUplinkReceivingGain() {
        return dataUplinkReceivingGain;
    }

    public void setDataUplinkReceivingGain(String dataUplinkReceivingGain) {
        this.dataUplinkReceivingGain = dataUplinkReceivingGain;
    }

    public String getBusinessDownlinkFrequency() {
        return businessDownlinkFrequency;
    }

    public void setBusinessDownlinkFrequency(String businessDownlinkFrequency) {
        this.businessDownlinkFrequency = businessDownlinkFrequency;
    }

    public String getBusinessDownlinkErp() {
        return businessDownlinkErp;
    }

    public void setBusinessDownlinkErp(String businessDownlinkErp) {
        this.businessDownlinkErp = businessDownlinkErp;
    }

    public String getBusinessUplinkFrequency() {
        return businessUplinkFrequency;
    }

    public void setBusinessUplinkFrequency(String businessUplinkFrequency) {
        this.businessUplinkFrequency = businessUplinkFrequency;
    }

    public String getBusinessUplinkReceivingGain() {
        return businessUplinkReceivingGain;
    }

    public void setBusinessUplinkReceivingGain(String businessUplinkReceivingGain) {
        this.businessUplinkReceivingGain = businessUplinkReceivingGain;
    }

    public Float getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Float eccentricity) {
        this.eccentricity = eccentricity;
    }

    public Float getMajorSemiaxis() {
        return majorSemiaxis;
    }

    public void setMajorSemiaxis(Float majorSemiaxis) {
        this.majorSemiaxis = majorSemiaxis;
    }

    public BigDecimal getDipAngle() {
        return dipAngle;
    }

    public void setDipAngle(BigDecimal dipAngle) {
        this.dipAngle = dipAngle;
    }

    public BigDecimal getEquatorialRadius() {
        return equatorialRadius;
    }

    public void setEquatorialRadius(BigDecimal equatorialRadius) {
        this.equatorialRadius = equatorialRadius;
    }

    public BigDecimal getPerigeeAngularDistance() {
        return perigeeAngularDistance;
    }

    public void setPerigeeAngularDistance(BigDecimal perigeeAngularDistance) {
        this.perigeeAngularDistance = perigeeAngularDistance;
    }

    public Date getPerigeeMoment() {
        return perigeeMoment;
    }

    public void setPerigeeMoment(Date perigeeMoment) {
        this.perigeeMoment = perigeeMoment;
    }
}