package com.satchain.bean.bo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TeleControlContentBO {
    private String groundid;//地面站编号
    private String satelliteid;//卫星编号
    private Integer tasktype;//任务类型
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planstarttime;//任务开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planendtime;//任务结束时间
    private String taskcontent;//任务内容

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

    public Date getPlanstarttime() {
        return planstarttime;
    }

    public void setPlanstarttime(Date planstarttime) {
        this.planstarttime = planstarttime;
    }

    public Date getPlanendtime() {
        return planendtime;
    }

    public void setPlanendtime(Date planendtime) {
        this.planendtime = planendtime;
    }

    public String getTaskcontent() {
        return taskcontent;
    }

    public void setTaskcontent(String taskcontent) {
        this.taskcontent = taskcontent;
    }
}
