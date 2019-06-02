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
import java.io.File;
import java.io.FileInputStream;
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
    public Result teleDataDownload(@RequestParam("satellationId") String satellationId) {
        return Result.success(teleDataService.teleDataDownload(satellationId));
    }

    /**
     * 3.38 遥测数据导入
     * @param file
     * @return
     */
    @RequestMapping(value = "/teleDataUpload", method = RequestMethod.POST)
    public Result teleDataUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        String fileName="";
        String filePath="";
        Connection connection =null;
        ScriptRunner runner =null;
        String path = request.getSession().getServletContext().getRealPath("path");
        //上传脚本文件
        //fileName =  FileUtil.uploadFileSQL(file,request,path);
        fileName = FileUtil.getFileName(path);
        filePath = path+ File.separator+fileName;//上传文件的真实路径
        try{
            //获取指定数据源连接
            connection = DBConnection.getInstance().getConnection("dataSource8");
            runner = new ScriptRunner(connection);
            runner.setErrorLogWriter(null);
            runner.setLogWriter(null);
            runner.runScript(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DBConnection.closeConnection(connection);
        }
        return Result.success();
    }

    /**
     * 3.39 teleDateDelete遥测数据删除
     * @param starttime
     * @param stoptime
     * @return
     */
    @RequestMapping(value = "/teleDateDelete",method = RequestMethod.DELETE)
    public Result teleDateDelete(@RequestParam("starttime") String starttime,
                                 @RequestParam("stoptime") String stoptime){
        return Result.success();
    }
}
