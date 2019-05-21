package com.satchain.bean.vo;

public class ConstellationinfoVO {

    private String constellationId;//星座编号

    private String constellationName;//星座名称

    private Integer constellationType;//星座类型

    private String constellationOwners;//业主名

    public String getConstellationId() {
        return constellationId;
    }

    public void setConstellationId(String constellationId) {
        this.constellationId = constellationId;
    }

    public String getConstellationName() {
        return constellationName;
    }

    public void setConstellationName(String constellationName) {
        this.constellationName = constellationName;
    }

    public Integer getConstellationType() {
        return constellationType;
    }

    public void setConstellationType(Integer constellationType) {
        this.constellationType = constellationType;
    }

    public String getConstellationOwners() {
        return constellationOwners;
    }

    public void setConstellationOwners(String constellationOwners) {
        this.constellationOwners = constellationOwners;
    }
}
