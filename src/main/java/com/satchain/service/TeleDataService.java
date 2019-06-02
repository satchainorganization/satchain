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
        return null;
        /*ArrayList<File> fileList = getFiles(Constants.TELE_DATA_BASE_PATH);
        ArrayList<File> downloadFileList = new ArrayList<>();
        *//*ArrayList<String> iconNameList = new ArrayList<String>();//返回文件名数组
        for(int i=0;i<fileList.size();i++){
            String curpath = fileList.get(i).getPath();//获取文件路径
            iconNameList.add(curpath.substring(curpath.lastIndexOf("\\")+1));//将文件名加入数组
        }*//*
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        for(int i=0;i<fileList.size();i++){
            Long createTime= fileList.get(i).lastModified();
            if(createTime >= startTime.getTime() && createTime <= endTime.getTime()){
                downloadFileList.add(fileList.get(i));
            };

        }
        String path = Constants.TELE_DATA_BASE_PATH + startTime.getTime() + endTime.getTime();
        File file = new File(path);
        if (file.exists() && file.isDirectory() && file.list() != null) {
            return Arrays.asList(file.list());
        }
        return new ArrayList<>();*/
    }

    public boolean teleDataUpload(MultipartFile file) {

        File target = new File(Constants.TELE_DATA_BASE_PATH + FileUtil.getFileName(file.getOriginalFilename()));
        if (!target.exists()) {
            target.mkdirs();
        }
        try {
            file.transferTo(target);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
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