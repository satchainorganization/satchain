package com.satchain.bean.vo;

import java.util.List;

/**
 * @author 董少飞
 * // TODO: 2019/5/19 dsf
 * @date 2019/5/19
 */
public class DataVO {

    private String taskID;

    private List<String> fileList;

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public List<String> getFileList() {
        return fileList;
    }

    public void setFileList(List<String> fileList) {
        this.fileList = fileList;
    }

    public DataVO(String taskID, List<String> fileList) {
        this.taskID = taskID;
        this.fileList = fileList;
    }
}
