package com.satchain.bean.model;

public class FieldDefine {
    private Long id;

    private String fieldName;//字段名

    private Integer dataType;//数据类型

    private Double minData;//最小值

    private Double maxData;//最大值

    private String unit;//单位

    private Boolean showLable;//显示标志

    private String deviceName;//设备名

    private String moonNum;//卫星编号

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Double getMinData() {
        return minData;
    }

    public void setMinData(Double minData) {
        this.minData = minData;
    }

    public Double getMaxData() {
        return maxData;
    }

    public void setMaxData(Double maxData) {
        this.maxData = maxData;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Boolean getShowLable() {
        return showLable;
    }

    public void setShowLable(Boolean showLable) {
        this.showLable = showLable;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getMoonNum() {
        return moonNum;
    }

    public void setMoonNum(String moonNum) {
        this.moonNum = moonNum;
    }
}