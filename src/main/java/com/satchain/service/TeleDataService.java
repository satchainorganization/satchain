package com.satchain.service;

import com.satchain.bean.model.FieldDefine;
import com.satchain.bean.vo.FieldVO;
import com.satchain.commons.constants.Constants;
import com.satchain.commons.utils.DynamicDataSourceHolder;
import com.satchain.commons.utils.FileUtil;
import com.satchain.dao.TeleDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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

    @Autowired
    private TeleDataMapper teleDataMapper;

    public Integer teleDataDownload(String satellationId, HttpServletResponse response) {

        List<FieldVO> fieldDefines = fieldDefineService.queryFieldByIdAndName(satellationId,null);
        if (fieldDefines == null || fieldDefines.size() <= 0){
            return -1;
        }
        for (FieldVO field : fieldDefines){
            //mysqldump -h localhost -u root -p satchain_new 字段定义表>c:\mysql\mytable.sql
            String command = new String("cmd /c mysqldump -h localhost -u"+Constants.JDBC_USER+" -p"+
                    Constants.JDBC_PASSWORD+" --databases satchain_new --tables "+ satellationId + field.getDeviceName() + " >> c:\\mysql\\mytable.sql");
            //String command = new String("cmd /c mysqldump -h localhost -u"+Constants.JDBC_USER+" -p"+
                    //Constants.JDBC_PASSWORD+" --databases "+Constants.JDBC_EXPORTDATABASENAME+ " --tables 2324" + " > c:\\mysql\\mytable.sql");

            Runtime runtime = Runtime.getRuntime();
            try {
                //cmd /k在执行命令后不关掉命令行窗口  cmd /c在执行完命令行后关掉命令行窗口   \\表示转译符也可使用/替代，linux使用/
                Process process = runtime.exec(command);
                new BufferedReader(new InputStreamReader(process.getInputStream()));

                String fileName = "c:\\mysql\\mytable.sql";
                InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
                response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
                response.setContentType("multipart/form-data");
                BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
                //boolean var13 = false;

                int len;
                while((len = bis.read()) != -1) {
                    out.write(len);
                    out.flush();
                }
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return 0;
    }

    public void teleDataUpload(MultipartFile file) throws IOException {

        /*String path = "/var/lib/tomcat8/webapps/";
        String fileName = file.getOriginalFilename();
        File dir = new File(path, fileName);*/
        String name = file.getName();
        String originalFilename = file.getOriginalFilename();
        String fileName = FileUtil.getFileName(originalFilename);
        try {
            File target = new File(Constants.DATA_BASE_PATH + fileName);
            if (!target.exists()){
                target.mkdirs();
            }
            //target.createNewFile();
            file.transferTo(target);
            Runtime runtime = Runtime.getRuntime();
            //mysql -h localhost -u root -p123456 -D satellite < c:\mysql\edu.sql
            String command = "cmd /c mysql -uroot -p123456 -D " + Constants.JDBC_EXPORTDATABASENAME + " < " + Constants.DATA_BASE_PATH + originalFilename;
            Process process = runtime.exec(command);
            //Process process = runtime.exec("cmd /c mysql -uroot -p123456 -D "+satellite < c:\\mysql\\edu.sql");
            new BufferedReader(new InputStreamReader(process.getInputStream()));
        } catch (IOException e) {

            e.printStackTrace();
        }
        //>mysql -h localhost -u root -p -D satellite < c:\mysql\edu.sql
        /*
        //执行命令行
        Runtime runtime = Runtime.getRuntime();
        try {
            //cmd /k在执行命令后不关掉命令行窗口  cmd /c在执行完命令行后关掉命令行窗口   \\表示转译符也可使用/替代，linux使用/
            Process process = runtime.exec(command);
            System.out.println("导入成功》》》》》》》》》》》》》》》");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
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

    public void teleDataDelete(String satellationId) {
        List<FieldVO> fieldDefines = fieldDefineService.queryFieldByIdAndName(satellationId,null);
        //DynamicDataSourceHolder.setDataSource("satchain_new");
        //teleDataMapper.dropTable("2324");
        for (FieldVO field : fieldDefines){
            //DynamicDataSourceHolder.setDataSource("satchain_new");
            teleDataMapper.dropTable(satellationId+field.getDeviceName());
        }
    }
}