package com.satchain.bean.model;

/**
 * 星座信息表
 */
public class Constellationinfo {
    private Long id;

    private String constellationUuid;//星座编号

    private String constellationName;//星座名称

    private Integer constellationType;//星座类型

    private String userName;//业主名

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConstellationUuid() {
        return constellationUuid;
    }

    public void setConstellationUuid(String constellationUuid) {
        this.constellationUuid = constellationUuid;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}