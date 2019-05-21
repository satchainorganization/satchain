package com.satchain.controller.web;

import com.satchain.bean.vo.SatelliteInfoVO;
import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.result.Result;
import com.satchain.service.SatelliteinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 卫星信息表：增删改查
 */
@RestController
@RequestMapping("/")
public class SatelliteinfoController {

    @Autowired
    private SatelliteinfoService satelliteinfoService;
    /**
     * 27卫星信息查询
     */
    @RequestMapping(value = "/querySatellite", method = RequestMethod.POST)
    public Result querySatellite(@RequestParam("satelliteId") String satelliteId, @RequestParam("satelliteName") String satelliteName){
        return Result.success(satelliteinfoService.querySatelliteInfo(satelliteId,satelliteName));
    }
    /**
     * 28新增卫星
     */
    @RequestMapping(value = "/addSatellite", method = RequestMethod.POST)
    public Result addSatellite(SatelliteInfoVO bo) throws Exception {

        Assert.notNull(bo,"参数错误！");
        Assert.notNull(bo.getSatelliteId(),"参数错误！");
        int n = satelliteinfoService.insertSatellite(bo);
        if (n == 0){
            return Result.failure(ResponseCodeEnum.ERROR,"新增卫星失败！");
        }
        return Result.success();
    }
    /**
     * 29 删除卫星信息
     */
    @RequestMapping(value = "/deleteSatellite", method = RequestMethod.DELETE)
    public Result deleteSatellite(@RequestParam("satelliteId") String satelliteId, @RequestParam("satelliteName") String satelliteName){
        int n = satelliteinfoService.deleteSatelliteInfo(satelliteId,satelliteName);
        if (n == 0){
            return Result.failure(ResponseCodeEnum.ERROR,"删除卫星信息失败！");
        }
        return Result.success();
    }
    /**
     * 30 更改卫星信息
     */
    @RequestMapping(value = "/updateSatellite", method = RequestMethod.POST)
    public Result updateSatellite(SatelliteInfoVO bo) throws Exception {
        Assert.notNull(bo,"参数错误！");
        Assert.notNull(bo.getSatelliteId(),"参数错误！");
        int n = satelliteinfoService.updateSatelliteInfo(bo);
        if (n == 0){
            return Result.failure(ResponseCodeEnum.ERROR,"更改卫星信息失败！");
        }
        return Result.success();
    }
}
