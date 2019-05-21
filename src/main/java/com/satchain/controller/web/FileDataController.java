package com.satchain.controller.web;

import com.satchain.bean.bo.DataBO;
import com.satchain.bean.vo.DataVO;
import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.result.Result;
import com.satchain.service.DataService;
import com.satchain.service.TeleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

// TODO: 2019/5/21
//@Controller
public class FileDataController {

    @Autowired
    private TeleDataService teleDataService;

    private DataService dataService;
    
    /**
     *3.14 queryDownData下行数据查询
     * @return
     */
    @RequestMapping(value = "/queryDownRecord",method = RequestMethod.POST)
    public Result queryDownData(DataBO dataBO){

        // TODO: 2019/5/19 返回结果是怎么样
        List<DataVO> dataVOList = dataService.queryDownRecord(dataBO);
        return Result.success(dataVOList);
    }

    /**
     * 3.15 uploadData上传数据
     * @param file 要上传的具体文件
     * @return
     */
    @RequestMapping(value = "/downloadData",method = RequestMethod.POST)
    public Result downloadData(MultipartFile file, DataBO dataBO){

        if(dataService.uploadData(file, dataBO)) {
            return Result.success();
        } else {
            return Result.failure(ResponseCodeEnum.ERROR);
        }
    }

    /**
     *3.16 queryUpData上行数据查询
     * @return
     */
    @RequestMapping(value = "/queryDownData",method = RequestMethod.POST)
    public Result queryUpData(DataBO dataBO){

        return Result.success(dataService.queryUpData(dataBO));
    }

    /**
     * 3.37 teleDataDownload遥测数据导出
     * @param starttime
     * @param stoptime
     * @return
     */
    @RequestMapping(value = "/teleDataDownload",method = RequestMethod.POST)
    public Result teleDataDownload(@RequestParam("starttime") Date starttime,
                                   @RequestParam("stoptime") Date stoptime){
        return Result.success(teleDataService.teleDataDownload(starttime, stoptime));
    }


    /**
     * 3.38 teleDateUpload遥测数据导入
     * @param file
     * @return
     */
    @RequestMapping(value = "/teleDateUpload",method = RequestMethod.POST)
    public Result teleDateUpload(@RequestParam("file") MultipartFile file){
        if(teleDataService.teleDataUpload(file)) {
            return Result.success();
        }
        return Result.failure(ResponseCodeEnum.ERROR);
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
