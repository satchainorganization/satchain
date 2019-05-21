package com.satchain.controller.web;

import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.result.Result;
import com.satchain.service.TeleDataService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @author 董少飞
 * // TODO: 2019/5/19 dsf
 * @date 2019/5/19
 */
@RestController
public class TeleDataController {

    private TeleDataService teleDataService;

    public Result teleDataDownload(@RequestParam("starttime") Date starttime,
                                   @RequestParam("stoptime") Date stoptime) {
        return Result.success(teleDataService.teleDataDownload(starttime, stoptime));
    }

    public Result teleDataUpload(MultipartFile file) {

        if(teleDataService.teleDataUpload(file)) {
            return Result.success();
        }
        return Result.failure(ResponseCodeEnum.ERROR);
    }
}
