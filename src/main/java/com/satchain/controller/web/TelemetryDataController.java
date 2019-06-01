package com.satchain.controller.web;

import com.satchain.commons.result.Result;
import com.satchain.service.TelemetryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TelemetryDataController {

    @Autowired
    private TelemetryDataService telemetryDataService;

    //3.13 queryTeleData遥测数据表读取
    @RequestMapping(value = "/queryTeleData",method = RequestMethod.POST)
    public Result queryTeleData(@RequestParam("satelliteId") String satelliteId,
                                @RequestParam("deviceName") String deviceName){
        Assert.notNull(satelliteId,"id不能为空！");
        Assert.notNull(deviceName,"name不能为空！");
        HashMap<String,Object> result = telemetryDataService.queryTeleData(satelliteId,deviceName);
        return Result.success(result);
    }


}
