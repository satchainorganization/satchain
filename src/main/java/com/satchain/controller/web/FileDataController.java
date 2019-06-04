package com.satchain.controller.web;

import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.result.Result;
import com.satchain.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;

@Controller
public class FileDataController {

    @Autowired
    private DataService dataService;

    /**
     *3.14 queryDownData下行数据查询
     * @param constellationid 星座编号
     * @param satelliteid 卫星编号
     * @param starttime 开始时间
     * @param endtime 结束时间
     * @return
     */
    @RequestMapping(value = "/queryDownRecord",method = RequestMethod.POST)
    public Result queryDownData(@RequestParam("constellationid") String constellationid,
                                @RequestParam("satelliteid") String satelliteid,
                                @RequestParam("starttime") String starttime,
                                @RequestParam("endtime") String endtime) throws ParseException {
        Assert.notNull(constellationid,"参数不能为空");
        Assert.notNull(satelliteid,"参数不能为空");

        return Result.success(dataService.queryDownRecord(constellationid,satelliteid,starttime,endtime));
    }

    /**
     * 3.15 uploadData上传数据
     * @param file 要上传的具体文件
     * @param taskId 任务编号
     * @return
     */
    @RequestMapping(value = "/uploadData",method = RequestMethod.POST)
    public Result downloadData(@RequestParam("file") MultipartFile file,
                               @RequestParam("taskId") Integer taskId){

        if(dataService.uploadData(file, taskId)) {
            return Result.success();
        } else {
            return Result.failure(ResponseCodeEnum.ERROR,"文件上传失败");
        }
    }

    /**
     *3.16 queryUpData上行数据查询
     * @param constellationid 星座编号
     * @param satelliteid 卫星编号
     * @param starttime 开始时间
     * @param endtime 结束时间
     * @return
     */
    @RequestMapping(value = "/queryupData",method = RequestMethod.POST)
    public Result queryupData(@RequestParam("constellationid") String constellationid,
                                @RequestParam("satelliteid") String satelliteid,
                                @RequestParam("starttime") String starttime,
                                @RequestParam("endtime") String endtime) throws ParseException {

        Assert.notNull(constellationid,"参数不能为空");
        Assert.notNull(satelliteid,"参数不能为空");

        return Result.success(dataService.queryDownRecord(constellationid,satelliteid,starttime,endtime));
    }




}
