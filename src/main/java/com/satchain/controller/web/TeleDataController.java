package com.satchain.controller.web;

import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.result.Result;
import com.satchain.service.TeleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @date 2019/5/19
 */
@RestController
public class TeleDataController {

    @Autowired
    private TeleDataService teleDataService;

    /**
     * 遥测数据导出
     * @param satellationId
     * @return
     */
    @RequestMapping(value = "/teleDataDownload", method = RequestMethod.POST)
    public Result teleDataDownload(@RequestParam("satellationId") String satellationId) {
        return Result.success(teleDataService.teleDataDownload(satellationId));
    }

    @RequestMapping(value = "/teleDataUpload", method = RequestMethod.POST)
    public Result teleDataUpload(@RequestParam("file") MultipartFile file) {

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
