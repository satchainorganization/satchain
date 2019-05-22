package com.satchain.controller.web;

import com.satchain.bean.vo.FieldVO;
import com.satchain.commons.result.Result;
import com.satchain.service.FieldDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * bingo
 */
@RestController
@RequestMapping("/")
public class FieldDefineController {
    @Autowired
    private FieldDefineService fieldDefineService;

    /**
     * 3.12 字段定义表读取
     * @param satelliteId
     * @param deviceName
     * @return
     */
    @RequestMapping(value = "/queryField",method = RequestMethod.POST)
    public Result queryField(@RequestParam("satelliteId") String satelliteId,
                             @RequestParam("deviceName") String deviceName){
        Assert.notNull(satelliteId,"id不存在！");
        List<FieldVO> fieldVOS = fieldDefineService.queryFieldByIdAndName(satelliteId,deviceName);
        return Result.success(fieldVOS);
    }
}
