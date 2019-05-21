package com.satchain.bean.bo;

public class QueryTaskBO {
    private Integer taskid;//任务编号
    private String constellationid;//星座编号
    private String satelliteid;//卫星编号
    private Integer tasktype;//任务类型：100:遥测 101:遥控 110:数据上行 111:数据下行
    private Integer distrisign;//0:未发布1：请求发布2:已发布3：请求撤回4:已撤回5:已执行
    private String planstarttime;//任务开始时间
    private String planstoptime;//任务结束时间
    /*private Integer pageNum;//当前页数
    private Integer pageSize;//每页显示条数*/

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
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

    public Integer getTasktype() {
        return tasktype;
    }

    public void setTasktype(Integer tasktype) {
        this.tasktype = tasktype;
    }

    public Integer getDistrisign() {
        return distrisign;
    }

    public void setDistrisign(Integer distrisign) {
        this.distrisign = distrisign;
    }

    public String getPlanstarttime() {
        return planstarttime;
    }

    public void setPlanstarttime(String plantarttime) {
        this.planstarttime = plantarttime;
    }

    public String getPlanstoptime() {
        return planstoptime;
    }

    public void setPlanstoptime(String planstoptime) {
        this.planstoptime = planstoptime;
    }
/*
    public Integer getPageNum() {
        if (pageNum == null) {
            return 1;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if (pageSize == null) {
            return 3;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStart() {
        return (getPageNum() - 1) * getPageSize();
    }*/
}
