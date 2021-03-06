package com.satchain.controller.web;

import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.result.Result;
import com.satchain.commons.utils.FileUtil;
import com.satchain.service.DBConnection;
import com.satchain.service.TeleDataService;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Date;

/**
 * @date 2019/5/19
 */
@RestController
public class TeleDataController {

    @Autowired
    private TeleDataService teleDataService;

    /**
     * 3.37 遥测数据导出
     * @param satellationId
     * @return
     */
    @RequestMapping(value = "/teleDataDownload", method = RequestMethod.POST)
    public Result teleDataDownload(@RequestParam("satellationId") String satellationId, HttpServletResponse response) {
        int result = teleDataService.teleDataDownload(satellationId,response);
        if (result == -1){
            return Result.failure(ResponseCodeEnum.ERROR,"数据库中不存在该表！");
        }
        return Result.success();
    }

    /**
     * 3.38 遥测数据导入
     * @param file
     * @return
     */
    @RequestMapping(value = "/teleDataUpload", method = RequestMethod.POST)
    public Result teleDataUpload(@RequestParam("file") MultipartFile file , HttpServletRequest request) throws IOException {
        teleDataService.teleDataUpload(file);
        return Result.success();
    }

    /**
     * 3.39 teleDateDelete遥测数据删除
     * @param satellationId
     * @return
     */
    @RequestMapping(value = "/teleDateDelete",method = RequestMethod.DELETE)
    public Result teleDateDelete(@RequestParam("satellationId") String satellationId){
        teleDataService.teleDataDelete(satellationId);
        return Result.success();
    }
}
