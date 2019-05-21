package com.satchain.bean.vo;

public class QueryTaskAssignmentVO {
    private Integer taskid;//任务编号
    private String groundid;//地面站编号
    private String satelliteid;//卫星编号
    private Integer tasktype;//任务类型：100:遥测 101:遥控 110:数据上行 111:数据下行
    private String taskformutime;//任务制定时间
    private String planstartime;//计划开始时间
    private String planendtime;//计划结束时间
    private String taskstarttime;//任务开始时间
    private String taskendtime;//任务结束时间
    private Integer distrisign;//0:未发布1：请求发布2:已发布3：请求撤回4:已撤回5:已执行
    private Boolean datadistrisign;//任务标志：0：未分发，1：已分发
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

    public String getTaskformutime() {
        return taskformutime;
    }

    public void setTaskformutime(String taskformutime) {
        this.taskformutime = taskformutime;
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
