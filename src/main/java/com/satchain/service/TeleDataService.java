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

    public List<String> teleDataDownload(String satellationId) {

        List<FieldVO> fieldDefines = fieldDefineService.queryFieldByIdAndName(satellationId,null);
        for (FieldVO field : fieldDefines){
            //c:\>mysqldump -h localhost -u root -p mydb mytable>e:\mysql\mytable.sql
            //mysqldump -h localhost -u root -p satchain_new 字段定义表>c:\mysql\mytable.sql
            String command = new String("cmd /c mysqldump -h localhost -u"+Constants.JDBC_USER+" -p"+
                    Constants.JDBC_PASSWORD+" "+Constants.JDBC_EXPORTDATABASENAME+ " " +"用户信息表 > c:\\mysql\\mytable.sql");
            /*String command = new String("cmd /c mysqldump -h localhost -u"+Constants.JDBC_USER+" -p"+
                    Constants.JDBC_PASSWORD+" "+Constants.JDBC_EXPORTDATABASENAME+ " " + satellationId+field.getDeviceName() + " >"+Constants.JDBC_EXPORTPATH);*/

            Runtime runtime = Runtime.getRuntime();
            try {
                //cmd /k在执行命令后不关掉命令行窗口  cmd /c在执行完命令行后关掉命令行窗口   \\表示转译符也可使用/替代，linux使用/
                Process process = runtime.exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void teleDataUpload() {

        //>mysql -h localhost -u root -p -D satellite < c:\mysql\edu.sql
        /*String command = new String("cmd /k mysql"+" -h"+Constants.JDBC_HOST+" -u"+Constants.JDBC_USER
        +" -p"+Constants.JDBC_PASSWORD+" "+Constants.JDBC_EXPORTDATABASENAME+" <"+Constants.JDBC_EXPORTPATH);*/
        /*String command = new String("cmd /c mysql"+" -h "+Constants.JDBC_HOST+" -u "+Constants.JDBC_USER
                +" -p "+Constants.JDBC_PASSWORD+" "+" -D satellite"+" <"+Constants.JDBC_EXPORTPATH);*/
        String command = new String("cmd /k mysql -h localhost -u root -p 123456 -D satellite < c:\\mysql\\edu.sql");

        //String command = new String("cmd /c mysql -h " + Constants.JDBC_HOST + " -u "+Constants.JDBC_USER
                //+ " -p " + Constants.JDBC_PASSWORD + " -D satellite" + " < "+Constants.JDBC_EXPORTPATH);
        //执行命令行
        Runtime runtime = Runtime.getRuntime();
        try {
            //cmd /k在执行命令后不关掉命令行窗口  cmd /c在执行完命令行后关掉命令行窗口   \\表示转译符也可使用/替代，linux使用/
            Process process = runtime.exec("cmd /k mysql -h localhost -u root -p -D satellite < c:\\mysql\\edu.sql");
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

    public void teleDataDelete(String satellationId) {
        List<FieldVO> fieldDefines = fieldDefineService.queryFieldByIdAndName(satellationId,null);
        for (FieldVO field : fieldDefines){
            try {
                 Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动
                 System.out.println("加载数据库驱动成功");
                 String url="jdbc:mysql://localhost:3306/satchain_new";//声明自己的数据库test的url
                 String user="root";//声明自己的数据库账号
                 String password="123456";//声明自己的数据库密码
                 //建立数据库连接，获得连接对象conn
                 Connection conn= DriverManager.getConnection(url,user,password);
                 System.out.println("连接数据库成功");
                 //String sql="delete from" + satellationId + field.getDeviceName();//生成一条sql语句
                 String sql = "DROP TABLE IF EXISTS `地面站信息表`;";
                 //String sql = "delete from `用户信息表` where 用户名=gelijing";
                 Statement stmt=conn.createStatement();//创建Statement对象
                 stmt.executeUpdate(sql);//执行sql语句
                 System.out.println("数据库删除成功");
                 conn.close();
                 System.out.println("数据库关闭成功");//关闭数据库的连接
             } catch (Exception e) {
                 e.printStackTrace();
             }
        }
    }
}