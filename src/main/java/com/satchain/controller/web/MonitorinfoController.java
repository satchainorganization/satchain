package com.satchain.controller.web;

import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.result.Result;
import com.satchain.service.MonitorinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 监控信息表
 */
@RestController
public class MonitorinfoController {
    @Autowired
    private MonitorinfoService monitorinfoService;
    /**
     * 40 添加监控器
     */
    @RequestMapping(value = "/addMonitor", method = RequestMethod.POST)
    public Result addMonitor(@RequestParam("monitorStation") String monitorStation,
                             @RequestParam("monitorid") String monitorid,
                             @RequestParam("monitorUri") String monitorUri) throws Exception {
        Assert.notNull(monitorStation,"参数错误！");
        Assert.notNull(monitorid,"参数错误");
        Assert.notNull(monitorUri,"参数错误");

        int n = monitorinfoService.addMonitorInfo(monitorStation,monitorid,monitorUri);
        if (n<=0){
            return Result.failure(ResponseCodeEnum.ERROR,"添加监视器失败！");
        }
        return Result.success();
    }
    /**
     * 41 查询监视器
     */
    @RequestMapping(value = "/queryMonitor", method = RequestMethod.POST)
    public Result queryMonitor(@RequestParam("monitorid") String monitorid, @RequestParam("monitorStation") String monitorStation){

        return Result.success(monitorinfoService.queryMonitorInfo(monitorid,monitorStation));
    }
    /**
     * 42 删除监控器
     */
    @RequestMapping(value = "/deleteMonitor", method = RequestMethod.DELETE)
    public Result deleteMonitor(@RequestParam("monitorid") String monitorid){
        Assert.notNull(monitorid,"参数错误！");

        int n = monitorinfoService.deleteMonitorInfo(monitorid);
        if (n<=0){
            return Result.failure(ResponseCodeEnum.ERROR,"删除监控器失败！");
        }
        return Result.success();
    }
    /**
     * 43 编辑监控器
     */
    @RequestMapping(value = "/editMonitor", method = RequestMethod.POST)
    public Result editMonitor(@RequestParam("monitorid") String monitorid, @RequestParam("monitorStation") String monitorStation,
                              @RequestParam("monitorUri") String monitorUri) throws Exception {
        Assert.notNull(monitorid,"参数错误！");
        Assert.notNull(monitorStation,"参数错误！");
        Assert.notNull(monitorUri,"参数错误！");
        int n = monitorinfoService.updateMonitorInfo(monitorid,monitorStation,monitorUri);
        if (n<=0){
            return Result.failure(ResponseCodeEnum.ERROR,"编辑监控器失败！");
        }
        return Result.success();
    }
}
