package com.satchain.bean.bo;

public class AddTaskBO {
    private String groundid;//地面站编号
    private String satelliteid;//卫星编号
    private Integer tasktype;//任务类型：100:遥测 101:遥控 110:数据上行 111:数据下行
    private String planstarttime;//计划开始时间
    private String planendtime;//计划结束时间

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
}
