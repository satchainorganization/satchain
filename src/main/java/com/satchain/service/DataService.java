package com.satchain.service;

import com.satchain.bean.bo.DataBO;
import com.satchain.bean.vo.DataVO;
import com.satchain.commons.constants.Constants;
import com.satchain.commons.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author 董少飞
 * // TODO: 2019/5/19 dsf
 * @date 2019/5/19
 */
@Service
public class DataService {

    public String getPath(DataBO dataBO) {

        StringBuilder pathBuilder = new StringBuilder();
        if(dataBO.getTaskID() == null) {
            return pathBuilder.toString();
        }
        pathBuilder.append(dataBO.getTaskID());
        pathBuilder.append("/");
        if(StringUtils.isEmpty(dataBO.getConstellationid())) {
            return pathBuilder.toString();
        }
        pathBuilder.append(dataBO.getConstellationid());
        pathBuilder.append("/");
        if(StringUtils.isEmpty(dataBO.getSatelliteid())) {
            return pathBuilder.toString();
        }
        pathBuilder.append(dataBO.getSatelliteid());
        pathBuilder.append("/");

        // TODO: 2019/5/19 时间如何处理
        return pathBuilder.toString();
    }

    public List<DataVO> queryDownRecord(DataBO dataBO) {

        List<DataVO> dataVOList = new LinkedList<>();
        String path = getPath(dataBO);

        if("".equals(path)) {
            File baseDir = new File(Constants.DATA_BASE_PATH);
            File[] fileList = null;
            if(!baseDir.exists() || !baseDir.isDirectory() ||
                    (fileList = baseDir.listFiles()) == null) {
                return dataVOList;
            }

            for(File file : fileList) {
                DataVO dataVO = new DataVO(file.getPath(), getAllFilePath(file));
                dataVOList.add(dataVO);
            }
            return dataVOList;
        }

        File file = new File(Constants.DATA_BASE_PATH + path);
        DataVO dataVO = new DataVO(dataBO.getTaskID().toString(), getAllFilePath(file));
        dataVOList.add(dataVO);
        return dataVOList;
    }

    public List<String> getAllFilePath(File baseDir) {

        LinkedList<String> filesPath = new LinkedList<>();
        if(baseDir.exists()) {
            return filesPath;
        }

        if(baseDir.isFile()) {
            filesPath.add(baseDir.getAbsolutePath());
            return filesPath;
        }

        File[] fileList = null;
        if((fileList = baseDir.listFiles()) == null) {
            return filesPath;
        }
        for(File file : fileList) {
            filesPath.addAll(getAllFilePath(file));
        }

        return filesPath;
    }

    public boolean uploadData(MultipartFile file, DataBO dataBO) {

        String originalFilename = file.getOriginalFilename();
        String fileName = FileUtil.getFileName(originalFilename);

        String path = getPath(dataBO);
        try {
            File target = new File(Constants.DATA_BASE_PATH + path + fileName);
            target.createNewFile();
            file.transferTo(target);
            return true;
        } catch (IOException e) {

            e.printStackTrace();
            return false;
        }
    }

    public List<DataVO> queryUpData(DataBO dataBO) {

        return queryDownRecord(dataBO);
    }
}
