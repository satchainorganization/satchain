package com.satchain.service;

import com.satchain.bean.model.FieldDefine;
import com.satchain.bean.vo.FieldVO;
import com.satchain.commons.constants.Constants;
import com.satchain.commons.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author glj
 * @date 2019/5/19
 */
@Service
public class TeleDataService {

    @Autowired
    private FieldDefineService fieldDefineService;

    @Autowired
    private TelemetryDataService telemetryDataService;

    public List<String> teleDataDownload(String satellationId) {

        List<FieldVO> fieldDefines = fieldDefineService.queryFieldByIdAndName(satellationId,null);
        for (FieldVO field : fieldDefines){
            //c:\>mysqldump -h localhost -u root -p mydb mytable>e:\mysql\mytable.sql
            String command = new String("cmd /c mysqldump -u"+Constants.JDBC_USER+" -p"+
                    Constants.JDBC_PASSWORD+" "+Constants.JDBC_EXPORTDATABASENAME+ " " + satellationId+field.getDeviceName() + " >"+Constants.JDBC_EXPORTPATH);
            Runtime runtime = Runtime.getRuntime();
            try {
                //cmd /k在执行命令后不关掉命令行窗口  cmd /c在执行完命令行后关掉命令行窗口   \\表示转译符也可使用/替代，linux使用/
                Process process = runtime.exec(command);
            } catch (IOException e) {
                    // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    public void teleDataUpload(MultipartFile file) {

        String command = new String("cmd /k mysql"+" -h"+Constants.JDBC_HOST+" -u"+Constants.JDBC_USER
        +" -p"+Constants.JDBC_PASSWORD+" "+Constants.JDBC_EXPORTDATABASENAME+" <"+Constants.JDBC_EXPORTPATH);

        //执行命令行
        Runtime runtime = Runtime.getRuntime();
        try {
            //cmd /k在执行命令后不关掉命令行窗口  cmd /c在执行完命令行后关掉命令行窗口   \\表示转译符也可使用/替代，linux使用/
            Process process = runtime.exec(command);
            System.out.println("导入成功》》》》》》》》》》》》》》》");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private ArrayList<File> getFiles(String path){
        ArrayList<File> fileList = new ArrayList<File>();
        File file = new File(path);
        if(file.isDirectory()){
            File []files = file.listFiles();
            for(File fileIndex:files){
            //如果这个文件是目录，则进行递归搜索
            if(fileIndex.isDirectory()){
                getFiles(fileIndex.getPath());
                }else {
            //如果文件是普通文件，则将文件句柄放入集合中
                fileList.add(fileIndex);
                }
            }
        }
        return fileList;
    }

}