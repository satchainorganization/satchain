package com.satchain.bean.model;

/**
 * 遥控内容表
 */
public class Contentinfo {
    private Long id;

    private Integer taskUuid;//任务编号

    private String taskContent;//任务内容

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

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }
}