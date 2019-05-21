package com.satchain.bean.vo;

public class TaskInfoVO {
    private Integer taskid;//任务编号

    private String groundid;//地面站编号

    private String satelliteid;//卫星编号

    private Integer tasktype;//任务类型

    private String publishTime;//任务发布时间

    private String planstartime;//计划开始时间

    private String planendtime;//计划截止时间

    private String taskstarttime;//任务开始时间

    private String taskendtime;//任务结束时间

    private Integer distrisign;//分发标志

    private Boolean datadistrisign;//任务标志

    private Integer ack;//任务执行情况

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

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

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getPlanstartime() {
        return planstartime;
    }

    public void setPlanstartime(String planstartime) {
        this.planstartime = planstartime;
    }

    public String getPlanendtime() {
        return planendtime;
    }

    public void setPlanendtime(String planendtime) {
        this.planendtime = planendtime;
    }

    public String getTaskstarttime() {
        return taskstarttime;
    }

    public void setTaskstarttime(String taskstarttime) {
        this.taskstarttime = taskstarttime;
    }

    public String getTaskendtime() {
        return taskendtime;
    }

    public void setTaskendtime(String taskendtime) {
        this.taskendtime = taskendtime;
    }

    public Integer getDistrisign() {
        return distrisign;
    }

    public void setDistrisign(Integer distrisign) {
        this.distrisign = distrisign;
    }

    public Boolean getDatadistrisign() {
        return datadistrisign;
    }

    public void setDatadistrisign(Boolean datadistrisign) {
        this.datadistrisign = datadistrisign;
    }

    public Integer getAck() {
        return ack;
    }

    public void setAck(Integer ack) {
        this.ack = ack;
    }
}
