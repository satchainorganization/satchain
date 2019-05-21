package com.satchain.controller.web;

import com.satchain.bean.bo.DataBO;
import com.satchain.bean.vo.DataVO;
import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.result.Result;
import com.satchain.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 董少飞
 * // TODO: 2019/5/19 dsf
 * @date 2019/5/19
 */
@RestController
public class DataController {

    @Autowired
    private DataService dataService;

    @RequestMapping("/queryDownRecord")
    public Result queryDownRecord(DataBO dataBO) {
        // TODO: 2019/5/19 返回结果是怎么样
        List<DataVO> dataVOList = dataService.queryDownRecord(dataBO);
        return Result.success(dataVOList);
    }

    // TODO: 2019/5/19 接口是upload还是downLoad
    @RequestMapping("/uploadData")
    public Result uploadData(MultipartFile file, DataBO dataBO) {

        if(dataService.uploadData(file, dataBO)) {
            return Result.success();
        } else {
            return Result.failure(ResponseCodeEnum.ERROR);
        }
    }

    public Result queryUpData(DataBO dataBO) {

        return Result.success(dataService.queryUpData(dataBO));
    }
}
