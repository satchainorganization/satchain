package com.satchain.controller.web;

import com.satchain.bean.vo.LogInfoVO;
import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.result.Result;
import com.satchain.service.LoginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 日志内容表：查删
 * // TODO: 2019/5/23 mapper乱码
 */
@RestController
@RequestMapping("/")
public class LoginfoController {

    @Autowired
    private LoginfoService loginfoService;

    /**
     * 3.17日志查询
     */
    @RequestMapping(value = "/queryLog", method = RequestMethod.POST)
    public Result queryLog(@RequestParam("starttime") String startTime,
                           @RequestParam("stoptime") String stopTime){
        Assert.notNull(startTime,"参数错误！");
        Assert.notNull(stopTime,"参数错误！");
        List<LogInfoVO> loginfos = loginfoService.queryLogInfo(startTime,stopTime);
        return Result.success(loginfos);
    }

    /**
     * 3.18删除日志
     * // TODO: 2019/5/23 requestBody 400 无提示信息
     */
    @RequestMapping(value = "/deleteLog", method = RequestMethod.DELETE)
    public Result deleteLog(@RequestBody String starttime,
                            @RequestBody String stoptime){
        Assert.notNull(starttime,"参数错误！");
        Assert.notNull(stoptime,"参数错误！");
        int deleNum = loginfoService.deleteLogInfo(starttime, stoptime);
        if (deleNum == 0){
            return Result.failure(ResponseCodeEnum.ERROR,"无相应日志");
        }
        return Result.success();
    }
}
