package com.satchain.controller.web;

import com.satchain.commons.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.List;

@Controller
public class FileDataController {

    /**
     *3.14 queryDownData下行数据查询
     * @param taskID 任务编号
     * @param constellationid 星座编号
     * @param satelliteid 卫星编号
     * @param starttime 开始时间
     * @param endtime 结束时间
     * @return
     */
    @RequestMapping(value = "/queryDownRecord",method = RequestMethod.POST)
    public Result queryDownData(@RequestParam("taskID") String taskID,
                                @RequestParam("constellationid") String constellationid,
                                @RequestParam("satelliteid") String satelliteid,
                                @RequestParam("starttime") String starttime,
                                @RequestParam("endtime") String endtime){

        //文件逻辑
        return Result.success();
    }

    /**
     * 3.15 uploadData上传数据
     * @param file 要上传的具体文件
     * @param taskID 任务编号
     * @param constellationid 星座编号
     * @param satelliteid 卫星编号
     * @param taskstarttime 任务开始时间
     * @param taskendtime 任务结束时间
     * @return
     */
    @RequestMapping(value = "/downloadData",method = RequestMethod.POST)
    public Result downloadData(@RequestParam("file") File file,
                               @RequestParam("taskID") Integer taskID,
                               @RequestParam("constellationid") Integer constellationid,
                               @RequestParam("satelliteid") Integer satelliteid,
                               @RequestParam("taskstarttime") String taskstarttime,
                               @RequestParam("taskendtime") String taskendtime){

        //文件逻辑
        return Result.success();
    }

    /**
     *3.16 queryUpData上行数据查询
     * @param taskID 任务编号
     * @param constellationid 星座编号
     * @param satelliteid 卫星编号
     * @param starttime 开始时间
     * @param endtime 结束时间
     * @return
     */
    @RequestMapping(value = "/queryDownData",method = RequestMethod.POST)
    public Result queryDownData(@RequestParam("taskID") List taskID,
                                @RequestParam("constellationid") Integer constellationid,
                                @RequestParam("satelliteid") Integer satelliteid,
                                @RequestParam("starttime") String starttime,
                                @RequestParam("endtime") String endtime){

        //文件逻辑
        return Result.success();
    }

    /**
     * 3.37 teleDataDownload遥测数据导出
     * @param starttime
     * @param stoptime
     * @return
     */
    @RequestMapping(value = "/teleDataDownload",method = RequestMethod.POST)
    public Result teleDataDownload(@RequestParam("starttime") String starttime,
                                   @RequestParam("stoptime") String stoptime){
        return Result.success();
    }


    /**
     * 3.38 teleDateUpload遥测数据导入
     * @param file
     * @return
     */
    @RequestMapping(value = "/teleDateUpload",method = RequestMethod.POST)
    public Result teleDateUpload(@RequestParam("file") String file){
        return Result.success();
    }

    /**
     * 3.39 teleDateDelete遥测数据删除
     * @param starttime
     * @param stoptime
     * @return
     */
    @RequestMapping(value = "/teleDateDelete",method = RequestMethod.DELETE)
    public Result teleDateDelete(@RequestParam("starttime") String starttime,
                                 @RequestParam("stoptime") String stoptime){
        return Result.success();
    }


}
