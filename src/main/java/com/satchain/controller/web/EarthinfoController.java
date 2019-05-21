package com.satchain.controller.web;

import com.satchain.bean.model.Earthinfo;
import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.result.Result;
import com.satchain.service.EarthinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
// TODO: 2019/5/22 dsf
public class EarthinfoController {
    @Autowired
    private EarthinfoService earthinfoService;

    /**
     * 23地面站信息查询
     */
    @RequestMapping(value = "/queryGroundStation", method = RequestMethod.POST)
    public Result queryGroundStation(@RequestParam("groundId") String groundId, @RequestParam("groundName") String groundName){
        return Result.success(earthinfoService.queryEarthInfo(groundId,groundName));
    }
    /**
     * 24新增地面站
     */
    @RequestMapping(value = "/GroundStation", method = RequestMethod.POST)
    public Result GroundStation(Earthinfo bo) throws Exception {
        Assert.notNull(bo,"参数错误！");
        Assert.notNull(bo.getGroundId(),"参数错误！");
        Assert.notNull(bo.getGroundName(),"参数错误！");
        Assert.notNull(bo.getGroundTelemetryFre(),"参数错误！");
        Assert.notNull(bo.getGroundTelemetryGain(),"参数错误！");
        Assert.notNull(bo.getGroundTelecontrolErp(),"参数错误！");
        Assert.notNull(bo.getGroundTelecontrolFre(),"参数错误！");
        Assert.notNull(bo.getDataDownFre(),"参数错误！");
        Assert.notNull(bo.getDataDownGain(),"参数错误！");
        Assert.notNull(bo.getDataUpErp(),"参数错误！");
        Assert.notNull(bo.getDataUpFre(),"参数错误！");
        Assert.notNull(bo.getLon(),"参数错误！");
        Assert.notNull(bo.getLat(),"参数错误！");
        Assert.notNull(bo.getIp(),"参数错误！");
        Assert.notNull(bo.getGroundType(),"参数错误！");

        int n = earthinfoService.insertEarthInfo(bo);
        if (n == 0){
            return Result.failure(ResponseCodeEnum.ERROR,"新增地面站信息失败！");
        }
        return Result.success();
    }
    /**
     * 25 删除地面站
     */
    @RequestMapping(value = "/deleteGroundStation", method = RequestMethod.DELETE)
    public Result deleteGroundStation(@RequestParam("groundId") String groundId){
        Assert.notNull(groundId,"地面站id不能为空！");
        int n = earthinfoService.deleteEarthInfo(groundId);
        if (n == 0){
            return Result.failure(ResponseCodeEnum.ERROR,"删除地面站信息失败！");
        }
        return Result.success();
    }
    /**
     * 26 更改地面站信息
     */
    @RequestMapping(value = "/updateGroundStation", method = RequestMethod.PUT)
    public Result updateGroundStation(Earthinfo bo) throws Exception {
        Assert.notNull(bo,"参数错误！");
        Assert.notNull(bo.getGroundId(),"参数错误！");
        Assert.notNull(bo.getGroundName(),"参数错误！");
        Assert.notNull(bo.getGroundTelemetryFre(),"参数错误！");
        Assert.notNull(bo.getGroundTelemetryGain(),"参数错误！");
        Assert.notNull(bo.getGroundTelecontrolErp(),"参数错误！");
        Assert.notNull(bo.getGroundTelecontrolFre(),"参数错误！");
        Assert.notNull(bo.getDataDownFre(),"参数错误！");
        Assert.notNull(bo.getDataDownGain(),"参数错误！");
        Assert.notNull(bo.getDataUpErp(),"参数错误！");
        Assert.notNull(bo.getDataUpFre(),"参数错误！");
        Assert.notNull(bo.getLon(),"参数错误！");
        Assert.notNull(bo.getLat(),"参数错误！");
        Assert.notNull(bo.getIp(),"参数错误！");
        Assert.notNull(bo.getGroundType(),"参数错误！");

        int n = earthinfoService.updateEarthInfo(bo);
        if (n == 0){
            return Result.failure(ResponseCodeEnum.ERROR,"地面站信息更新失败！");
        }
        return Result.success();
    }
}
