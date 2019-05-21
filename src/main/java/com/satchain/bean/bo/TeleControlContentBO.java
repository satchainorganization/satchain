package com.satchain.bean.bo;

import java.sql.Blob;

public class TeleControlContentBO {
    private String groundid;//地面站编号
    private String satelliteid;//卫星编号
    private Integer tasktype;//任务类型
    private String planstarttime;//任务开始时间
    private String planendtime;//任务结束时间
    private Blob taskcontent;//任务内容

    public String getGroundid() {
        return groundid;
    }

    public void setGroundid(String groundid) {
        this.groundid = groundid;
    }

    public String getSatelliteid() {
        return satelliteid;
    }

    public void setSatelliteid(String satelliteid) {
        this.satelliteid = satelliteid;
    }

    public Integer getTasktype() {
        return tasktype;
    }

    public void setTasktype(Integer tasktype) {
        this.tasktype = tasktype;
    }

    public String getPlanstarttime() {
        return planstarttime;
    }

    public void setPlanstarttime(String planstarttime) {
        this.planstarttime = planstarttime;
    }

    public String getPlanendtime() {
        return planendtime;
    }

    public void setPlanendtime(String planendtime) {
        this.planendtime = planendtime;
    }

    public Blob getTaskcontent() {
        return taskcontent;
    }

    public void setTaskcontent(Blob taskcontent) {
        this.taskcontent = taskcontent;
    }
}
