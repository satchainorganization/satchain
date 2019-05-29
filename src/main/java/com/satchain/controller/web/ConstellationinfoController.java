package com.satchain.controller.web;

import com.satchain.bean.vo.ConstellationinfoVO;
import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.result.Result;
import com.satchain.service.ConstellationinfoService;
import com.satchain.service.SatelliteinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 星座信息表
 */
@RestController
public class ConstellationinfoController {

    @Autowired
    private SatelliteinfoService satelliteinfoService;

    @Autowired
    private ConstellationinfoService constellationinfoService;

    /**
     * 31 查詢星座下的所有卫星
     * @param constellationId
     * @return
     */
    @RequestMapping(value = "/queryAllSatellitesBycon" , method = RequestMethod.POST)
    public Result queryAllSatellitesBycon(@RequestParam("constellationId") String constellationId){

        Assert.notNull(constellationId,"参数错误！");

        List<Map<String, String>> satelliteInfoVOS = satelliteinfoService.querySatelliteInfoByConstrllationID(constellationId);
        return Result.success(satelliteInfoVOS);
    }

    /**
     * 32 查询全部星座
     */
    @RequestMapping(value = "/queryConstellationList", method = RequestMethod.POST)
    public Result queryConstellationList(){

        return Result.success(constellationinfoService.queryConstellationInfoList());
    }

    /**
     * 33 查询星座信息
     */
    @RequestMapping(value = "/queryConstellation", method = RequestMethod.POST)
    public Result queryConstellation(@RequestParam("constellationId") String constellationId){
        //Assert.notNull(constellationId,"参数错误！");
        if (constellationId == null || constellationId == ""){
            return Result.failure(ResponseCodeEnum.ERROR,"星座编号不能为空！");
        }
        return Result.success(constellationinfoService.queryConstellationInfo(constellationId));
    }
    /**
     * 34 新增星座
     */
    @RequestMapping(value = "/addConstellation", method = RequestMethod.POST)
    public Result addConstellation(@RequestParam("constellationId") String constellationId,
                                   @RequestParam("constellationName") String constellationName,
                                   @RequestParam("constellationType") Integer constellationType,
                                   @RequestParam("constellationOwners") String constellationOwners) throws Exception{
        Assert.notNull(constellationId,"参数错误！");
        Assert.notNull(constellationName,"参数错误！");
        Assert.notNull(constellationType,"参数错误！");
        Assert.notNull(constellationOwners,"参数错误！");

        int n = constellationinfoService.addConstellationInfo(constellationId,constellationName,constellationType,constellationOwners);
        if (n <= 0){
            Result.failure(ResponseCodeEnum.ERROR,"新增失败，星座已存在！");
        }
        return Result.success();
    }
    /**
     * 35 删除星座
     */
    @RequestMapping(value = "/deleteConstellation", method = RequestMethod.DELETE)
    public Result deleteConstellation(@RequestParam("constellationId") String constellationId,
                                      @RequestParam("constellationName") String constellationName){
        int n = constellationinfoService.deleteConstellationInfo(constellationId,constellationName);
        if (n<=0){
            Result.failure(ResponseCodeEnum.ERROR,"删除星座失败！");
        }
        return Result.success();
    }
    /**
     * 36 更改星座
     */
    @RequestMapping(value = "/updateConstellation", method = RequestMethod.POST)
    public Result updateConstellation(@RequestParam("constellationId") String constellationId,
                                      @RequestParam("constellationName") String constellationName,
                                      @RequestParam("constellationType") Integer constellationType,
                                      @RequestParam("constellationOwners") String constellationOwners){
        Result result = Result.success();
        Assert.notNull(constellationId,"参数错误！");
        Assert.notNull(constellationName,"参数错误！");
        Assert.notNull(constellationType,"参数错误！");
        Assert.notNull(constellationOwners,"参数错误！");
        int n = constellationinfoService.updateConstellationInfo(constellationId,constellationName,constellationType,constellationOwners);
        if (n<=0){
            result = Result.failure(ResponseCodeEnum.ERROR,"星座信息不存在，更新失败！");
        }
        ConstellationinfoVO con = new ConstellationinfoVO();

        con.setConstellationId(constellationId);
        con.setConstellationName(constellationName);
        con.setConstellationType(constellationType);
        con.setConstellationOwners(constellationOwners);
        result.setData(con);
        return result;
    }
}
