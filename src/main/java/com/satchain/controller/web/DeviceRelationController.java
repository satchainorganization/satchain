package com.satchain.controller.web;

import com.satchain.commons.result.Result;
import com.satchain.service.DeviceRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class DeviceRelationController {
    @Autowired
    private DeviceRelationService deviceRelationService;

    /**
     * 3.11设备列表读取
     * @param satelliteId
     * @return
     */
    @RequestMapping(value = "/queryDeviceRelation",method = RequestMethod.POST)
    public Result queryDeviceRelation(@RequestParam("satelliteId") String satelliteId){
        Assert.notNull(satelliteId,"参数错误！");
        List<Map<String, String>> deviceRelation = deviceRelationService.queryDevice(satelliteId);
        return Result.success(deviceRelation);
    }

}
