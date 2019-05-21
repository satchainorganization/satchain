package com.satchain.bean.model;

import java.util.Date;

/**
 * 任务分配表
 */
public class Taskinfo {
    private Long id;

    private Integer taskUuid;//任务编号 TODO 有改动，long改為int

    private String earthUuid;//地面站编号

    private String satelliteUuid;//卫星编号

    private Integer taskType;//任务类型 TODO 有改动，long改為int

    private Date taskReleaseTime;//任务发布时间

    private Date planStartTime;//计划开始时间

    private Date planEndTime;//计划截止时间

    private Date taskStartTime;//任务开始时间

    private Date taskEndTime;//任务结束时间

    private Integer distributionFlag;//分发标志 TODO byte 改为int

    private Boolean taskFlag;//任务标志

    private Integer ack;//任务执行情况

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTaskUuid() {
        return taskUuid;
    }

    public void setTaskUuid(Integer taskUuid) {
        this.taskUuid = taskUuid;
    }

    public String getEarthUuid() {
        return earthUuid;
    }

    public void setEarthUuid(String earthUuid) {
        this.earthUuid = earthUuid;
    }

    public String getSatelliteUuid() {
        return satelliteUuid;
    }

    public void setSatelliteUuid(String satelliteUuid) {
        this.satelliteUuid = satelliteUuid;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Date getTaskReleaseTime() {
        return taskReleaseTime;
    }

    public void setTaskReleaseTime(Date taskReleaseTime) {
        this.taskReleaseTime = taskReleaseTime;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    public Date getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(Date taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public Date getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public Integer getDistributionFlag() {
        return distributionFlag;
    }

    public void setDistributionFlag(Integer distributionFlag) {
        this.distributionFlag = distributionFlag;
    }

    public Boolean getTaskFlag() {
        return taskFlag;
    }

    public void setTaskFlag(Boolean taskFlag) {
        this.taskFlag = taskFlag;
    }

    public Integer getAck() {
        return ack;
    }

    public void setAck(Integer ack) {
        this.ack = ack;
    }
}