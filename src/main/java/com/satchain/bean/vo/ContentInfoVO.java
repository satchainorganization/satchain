package com.satchain.bean.vo;

import java.sql.Blob;

public class ContentInfoVO {
    private Integer taskID;//任务编号
    private String constellationid;//星座编号
    private String satelliteid;//卫星编号
    private String groundid;//地面站编号
    private Blob taskContent;//任务内容
    private String taskTime;//任务执行时间

    public Integer getTaskID() {
        return taskID;
    }

    public void setTaskID(Integer taskID) {
        this.taskID = taskID;
    }

    public String getConstellationid() {
        return constellationid;
    }

    public void setConstellationid(String constellationid) {
        this.constellationid = constellationid;
    }

    public String getSatelliteid() {
        return satelliteid;
    }

    public void setSatelliteid(String satelliteid) {
        this.satelliteid = satelliteid;
    }

    public String getGroundid() {
        return groundid;
    }

    public void setGroundid(String groundid) {
        this.groundid = groundid;
    }

    public Blob getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(Blob taskContent) {
        this.taskContent = taskContent;
    }

    public String getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(String taskTime) {
        this.taskTime = taskTime;
    }
}
