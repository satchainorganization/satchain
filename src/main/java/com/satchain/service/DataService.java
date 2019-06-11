package com.satchain.service;

import com.satchain.bean.model.Satelliteinfo;
import com.satchain.bean.model.Taskinfo;
import com.satchain.bean.vo.DataVO;
import com.satchain.commons.constants.Constants;
import com.satchain.commons.utils.FileUtil;
import com.satchain.dao.SatelliteinfoMapper;
import com.satchain.dao.TaskinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class DataService {

    @Autowired
    private SatelliteinfoMapper satelliteinfoMapper;

    @Autowired
    private TaskinfoMapper taskinfoMapper;

    public String getPath(Integer taskId) {

        StringBuilder pathBuilder = new StringBuilder();

        pathBuilder.append("卫星星座运管系统\\数据上行\\");

        Taskinfo taskinfo = taskinfoMapper.selectByTaskId(taskId);
        String satelliteUuid = taskinfo.getSatelliteUuid();
        List<Satelliteinfo> satelliteinfos = satelliteinfoMapper.selectBySatelliteId(satelliteUuid, null);
        String constellationType = satelliteinfos.get(0).getConstellationType();
        pathBuilder.append(constellationType + "\\" + satelliteUuid + "\\" + taskId + "\\");
        return pathBuilder.toString();
    }

    /**
     * 3.14 下行数据查询
     * 3.16 上行数据查询
     * @param constellationid
     * @param satelliteid
     * @param starttime
     * @param endtime
     * @return
     */
    public List<DataVO> queryDownRecord(String constellationid,String satelliteid,String starttime,String endtime) throws ParseException {

        List<DataVO> dataVOList = new ArrayList<>();
        List<Taskinfo> taskinfos = taskinfoMapper.queryBySatelliteId(satelliteid);
        String path = Constants.DATA_BASE_PATH + "卫星星座运管系统\\数据下行\\" + constellationid + "\\" + satelliteid;
        File baseDir = new File(path);
        if(!baseDir.exists() || !baseDir.isDirectory() ||
                baseDir.listFiles() == null) {
            return dataVOList;
        }
        long startTime = 0;
        long endTime = 0;
        if (!StringUtils.isEmpty(starttime)){
            startTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(starttime).getTime();
        }
        if (!StringUtils.isEmpty(endtime)){
            endTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(endtime).getTime();
        }
        for (Taskinfo taskinfo : taskinfos){
            File file = new File(path+"\\"+taskinfo.getTaskUuid());

            if (file.exists()) {
                File[] files = file.listFiles();
                if (null == files || files.length == 0) {
                    System.out.println("文件夹是空的!");
                    continue;
                } else {
                    for (File file2 : files) {
                        if (file2.isDirectory()) {
                            System.out.println("文件夹:" + file2.getAbsolutePath());
                            //traverseFolder2(file2.getAbsolutePath());
                        } else {
                            System.out.println("文件:" + file2.getAbsolutePath());
                            if ((file2.exists() && file2.lastModified()>=startTime && file2.lastModified()<=endTime) ||
                                    (file2.exists() && endTime ==0 && file2.lastModified() >= startTime)){
                                DataVO dataVO = new DataVO();
                                String absolutePath = file2.getAbsolutePath();
                                String[] temp = absolutePath.split("\\\\");
                                dataVO.setTaskId(Integer.valueOf(temp[temp.length-2]));
                                dataVO.setFileName(String.valueOf(taskinfo.getTaskUuid()));
                                SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
                                String timeText=format.format(file2.lastModified());
                                dataVO.setFileTime(timeText);
                                dataVO.setFileSize(file2.length());
                                dataVO.setUrl(file2.getPath());
                                dataVOList.add(dataVO);
                            }
                        }
                    }
                }
            } else {
                System.out.println("文件不存在!");
            }

        }
        return dataVOList;
    }

    public List<DataVO> queryUpRecord(String constellationid, java.lang.String satelliteid, String starttime, String endtime, String basePath) throws ParseException {

        List<DataVO> dataVOList = new ArrayList<>();
        //List<Taskinfo> taskinfos = taskinfoMapper.queryBySatelliteId(satelliteid);
        long startTime = 0;
        long endTime = 0;
        if (!StringUtils.isEmpty(starttime)){
            startTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(starttime).getTime();
        }
        if (!StringUtils.isEmpty(endtime)){
            endTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(endtime).getTime();
        }
        java.lang.String path = Constants.DATA_BASE_PATH + basePath;
        if (!StringUtils.isEmpty(constellationid) && !StringUtils.isEmpty(satelliteid)) {
            path = path + "\\" + constellationid + "\\" + satelliteid;
            File baseDir = new File(path);
            if (!baseDir.exists() || !baseDir.isDirectory() ||
                    baseDir.listFiles() == null) {
                return dataVOList;
            }

            File[] baseList = baseDir.listFiles();
            for (File base : baseList) {//任务编号层
                File file = new File(base.getAbsolutePath());
                if (file.exists()) {
                    File[] files = file.listFiles();
                    if (null == files || files.length == 0) {
                        System.out.println("文件夹是空的!");
                        continue;
                    } else {
                        for (File file2 : files) {
                            if (file2.isDirectory()) {
                                System.out.println("文件夹:" + file2.getAbsolutePath());
                                //traverseFolder2(file2.getAbsolutePath());
                            } else {
                                System.out.println("文件:" + file2.getAbsolutePath());
                                if ((file2.exists() && file2.lastModified() >= startTime && file2.lastModified() <= endTime) ||
                                        (file2.exists() && endTime == 0 && file2.lastModified() >= startTime)) {
                                    DataVO dataVO = new DataVO();
                                    String absolutePath = file2.getAbsolutePath();
                                    String[] temp = absolutePath.split("\\\\");
                                    dataVO.setTaskId(Integer.valueOf(temp[temp.length-2]));
                                    dataVO.setFileName(file2.getName());
                                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
                                    String timeText = format.format(file2.lastModified());
                                    dataVO.setFileTime(timeText);
                                    dataVO.setFileSize(file2.length());
                                    dataVO.setUrl(file2.getPath());
                                    dataVOList.add(dataVO);
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("文件不存在!");
                }
            }
        }
        if (!StringUtils.isEmpty(constellationid) && StringUtils.isEmpty(satelliteid)){
            path += "\\" + constellationid;
            File conFile = new File(path);
            if(!conFile.exists() || !conFile.isDirectory() ||
                    conFile.listFiles() == null) {
                return dataVOList;
            }

            File[] conList = conFile.listFiles();
            for (File base : conList){//卫星编号层
                File file = new File(base.getAbsolutePath());
                if(!file.exists() || !file.isDirectory() ||
                        file.listFiles() == null) {
                    return dataVOList;
                }
                File[] satList = file.listFiles();
                for (File sat : satList){
                    if (sat.exists()) {
                        File[] files = sat.listFiles();
                        if (null == files || files.length == 0) {
                            System.out.println("文件夹是空的!");
                            continue;
                        } else {
                            for (File file2 : files) {
                                if (file2.isDirectory()) {
                                    System.out.println("文件夹:" + file2.getAbsolutePath());
                                    //traverseFolder2(file2.getAbsolutePath());
                                } else {
                                    System.out.println("文件:" + file2.getAbsolutePath());
                                    if ((file2.exists() && file2.lastModified()>=startTime && file2.lastModified()<=endTime) ||
                                            (file2.exists() && endTime ==0 && file2.lastModified() >= startTime)){
                                        DataVO dataVO = new DataVO();
                                        String absolutePath = file2.getAbsolutePath();
                                        String[] temp = absolutePath.split("\\\\");
                                        dataVO.setTaskId(Integer.valueOf(temp[temp.length-2]));
                                        dataVO.setFileName(file2.getName());
                                        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
                                        String timeText=format.format(file2.lastModified());
                                        dataVO.setFileTime(timeText);
                                        dataVO.setFileSize(file2.length());
                                        dataVO.setUrl(file2.getPath());
                                        dataVOList.add(dataVO);
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("文件不存在!");
                    }
                }
            }

        }
        if (StringUtils.isEmpty(constellationid) && !StringUtils.isEmpty(satelliteid)){
            File baseFile = new File(path);//根路径
            if(!baseFile.exists() || !baseFile.isDirectory() ||
                    baseFile.listFiles() == null) {
                return dataVOList;
            }
            File[] bases = baseFile.listFiles();
            for (File ba : bases){//每一个con id
                File sat = new File(ba.getAbsolutePath() + "\\" + satelliteid);
                if(!sat.exists() || !sat.isDirectory() ||
                        sat.listFiles() == null) {
                    return dataVOList;
                }

                if (sat.exists()) {
                    File[] files = sat.listFiles();
                    if (null == files || files.length == 0) {
                        System.out.println("文件夹是空的!");
                        continue;
                    } else {
                        for (File file2 : files) {
                            if (file2.isDirectory()) {
                                /*System.out.println("文件夹:" + file2.getAbsolutePath());
                                //traverseFolder2(file2.getAbsolutePath());
                            } else {*/
                                File taskList = new File(file2.getAbsolutePath());
                                if(!taskList.exists() || !taskList.isDirectory() ||
                                        taskList.listFiles() == null) {
                                    return dataVOList;
                                }
                                File[] tasks = taskList.listFiles();
                                for (File task : tasks){
                                    //System.out.println("文件:" + task.getAbsolutePath());
                                    if ((task.exists() && task.lastModified()>=startTime && task.lastModified()<=endTime) ||
                                            (task.exists() && endTime ==0 && task.lastModified() >= startTime)){
                                        DataVO dataVO = new DataVO();
                                        String absolutePath = file2.getAbsolutePath();
                                        String[] temp = absolutePath.split("\\\\");
                                        dataVO.setTaskId(Integer.valueOf(temp[temp.length-2]));
                                        dataVO.setFileName(task.getName());
                                        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
                                        String timeText=format.format(task.lastModified());
                                        dataVO.setFileTime(timeText);
                                        dataVO.setFileSize(task.length());
                                        dataVO.setUrl(task.getAbsolutePath());
                                        dataVOList.add(dataVO);
                                    }
                                }

                            }
                        }
                    }
                } else {
                    System.out.println("文件不存在!");
                }

            }

        }
        if (StringUtils.isEmpty(constellationid) && StringUtils.isEmpty(satelliteid)){
            File baseFile = new File(path);
            if(!baseFile.exists() || !baseFile.isDirectory() ||
                    baseFile.listFiles() == null) {
                return dataVOList;
            }
            File[] bases = baseFile.listFiles();
            for (File ba : bases){
                File bf = new File(ba.getAbsolutePath());
                if(!bf.exists() || !bf.isDirectory() ||
                        bf.listFiles() == null) {
                    return dataVOList;
                }
                File[] bas = ba.listFiles();
                for (File base : bas){
                    File file = new File(base.getAbsolutePath());
                    if(!file.exists() || !file.isDirectory() ||
                            file.listFiles() == null) {
                        return dataVOList;
                    }
                    File[] satList = file.listFiles();
                    for (File sat : satList){
                        if (sat.exists()) {
                            File[] files = sat.listFiles();
                            if (null == files || files.length == 0) {
                                System.out.println("文件夹是空的!");
                                continue;
                            } else {
                                for (File file2 : files) {
                                    if (file2.isDirectory()) {
                                        System.out.println("文件夹:" + file2.getAbsolutePath());
                                        //traverseFolder2(file2.getAbsolutePath());
                                    } else {
                                        System.out.println("文件:" + file2.getAbsolutePath());
                                        if ((file2.exists() && file2.lastModified()>=startTime && file2.lastModified()<=endTime) ||
                                                (file2.exists() && endTime ==0 && file2.lastModified() >= startTime)){
                                            DataVO dataVO = new DataVO();
                                            String absolutePath = file2.getAbsolutePath();
                                            String[] temp = absolutePath.split("\\\\");
                                            dataVO.setTaskId(Integer.valueOf(temp[temp.length-2]));
                                            dataVO.setFileName(file2.getName());
                                            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
                                            String timeText=format.format(file2.lastModified());
                                            dataVO.setFileTime(timeText);
                                            dataVO.setFileSize(file2.length());
                                            dataVO.setUrl(file2.getPath());
                                            dataVOList.add(dataVO);
                                        }
                                    }
                                }
                            }
                        } else {
                            System.out.println("文件不存在!");
                        }
                    }
            }

            }
        }
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

    /**
     * 3。15 上传文件
     * @param file
     * @param taskId
     * @return
     */
    public boolean uploadData(MultipartFile file, Integer taskId) {

        String name = file.getName();
        String originalFilename = file.getOriginalFilename();
        String fileName = FileUtil.getFileName(originalFilename);

        String path = getPath(taskId);
        try {
            File target = new File(Constants.DATA_BASE_PATH + path + fileName);
            if (!target.exists()){
                target.mkdirs();
            }
            //target.createNewFile();
            file.transferTo(target);
            return true;
        } catch (IOException e) {

            e.printStackTrace();
            return false;
        }
    }


}
