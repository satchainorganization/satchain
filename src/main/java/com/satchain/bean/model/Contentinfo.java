package com.satchain.bean.model;

import java.sql.Blob;

/**
 * 遥控内容表
 */
public class Contentinfo {
    private Long id;

    private Integer taskUuid;//任务编号

    private Blob taskContent;//任务内容

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

    public Blob getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(Blob taskContent) {
        this.taskContent = taskContent;
    }
}