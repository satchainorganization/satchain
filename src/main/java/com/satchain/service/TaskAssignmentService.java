package com.satchain.service;

import com.satchain.bean.bo.AddTaskBO;
import com.satchain.bean.bo.QueryTaskBO;
import com.satchain.bean.model.Satelliteinfo;
import com.satchain.bean.model.Taskinfo;
import com.satchain.bean.vo.TaskInfoVO;
import com.satchain.commons.utils.TimeConvertUtil;
import com.satchain.dao.SatelliteinfoMapper;
import com.satchain.dao.TaskinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskAssignmentService {

    @Autowired
    private TaskinfoMapper taskinfoMapper;

    @Autowired
    private SatelliteinfoMapper satelliteinfoMapper;

    /**
     * 3 查询任务
     * @param bo
     * @return
     */
    public List<TaskInfoVO> queryTask(QueryTaskBO bo){
        Date startTime = TimeConvertUtil.str2date(bo.getPlanstarttime());
        Date endTime = TimeConvertUtil.str2date(bo.getPlanstoptime());

        List<String> satId = new ArrayList<>();
        if (!bo.getConstellationid().isEmpty()&&bo.getSatelliteid().isEmpty()){
            List<Satelliteinfo> satelliteinfos = satelliteinfoMapper.queryBySateOrConstID(null, bo.getConstellationid());
            for (Satelliteinfo sat : satelliteinfos){
                satId.add(sat.getSatelliteUuid());
            }
        }
        if (!bo.getSatelliteid().isEmpty()){
            satId.add(bo.getSatelliteid());
        }

        List<Taskinfo> taskinfoList = taskinfoMapper.queryTaskInfoByTaskBO(satId,bo.getTasktype(),bo.getDistrisign(),startTime,endTime);

        List<TaskInfoVO> taskInfoVOS = new ArrayList<>();
        for (Taskinfo taskinfo : taskinfoList){
            TaskInfoVO taskInfoVO = new TaskInfoVO();
            taskInfoVO.setTaskid(taskinfo.getTaskUuid());
            String publishTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(taskinfo.getTaskReleaseTime());
            taskInfoVO.setPublishTime(publishTime);
            taskInfoVO.setSatelliteid(taskinfo.getSatelliteUuid());
            taskInfoVO.setGroundid(taskinfo.getEarthUuid());
            taskInfoVO.setTasktype(taskinfo.getTaskType());
            String planstarttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(taskinfo.getPlanStartTime());
            taskInfoVO.setPlanstartime(planstarttime);
            String planendtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(taskinfo.getPlanEndTime());
            taskInfoVO.setPlanendtime(planendtime);
            String taskstarttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(taskinfo.getTaskStartTime());
            taskInfoVO.setPlanstartime(taskstarttime);
            String taskendtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(taskinfo.getTaskEndTime());
            taskInfoVO.setPlanendtime(taskendtime);
            taskInfoVO.setDistrisign(taskinfo.getDistributionFlag());
            taskInfoVO.setDatadistrisign(taskinfo.getTaskFlag());
            taskInfoVO.setAck(taskinfo.getAck());
            taskInfoVOS.add(taskInfoVO);
        }
        return taskInfoVOS;
    }

    /**
     * 4 新增任务
     * @param bo
     * @return
     */
    public Integer addTask(AddTaskBO bo){
        Timestamp startTime = TimeConvertUtil.str2dateTime(bo.getPlanstarttime());
        Timestamp endTime = TimeConvertUtil.str2dateTime(bo.getPlanendtime());

        Taskinfo taskinfo = new Taskinfo();
        taskinfo.setEarthUuid(bo.getGroundid());
        taskinfo.setSatelliteUuid(bo.getSatelliteid());
        taskinfo.setTaskType(bo.getTasktype());
        taskinfo.setPlanStartTime(startTime);
        taskinfo.setPlanEndTime(endTime);
        return taskinfoMapper.insert(taskinfo);

    }

    /**
     * 更新任务
     * @param bo
     */
    public Integer updateTask(QueryTaskBO bo) throws Exception {

        if (taskinfoMapper.selectByTaskId(bo.getTaskid()) == null){
            throw new Exception("数据不存在！");
        }
        Taskinfo taskinfo = new Taskinfo();
        taskinfo.setTaskUuid(bo.getTaskid());
        taskinfo.setSatelliteUuid(bo.getSatelliteid());
        taskinfo.setTaskType(bo.getTasktype());
        Timestamp startTime = TimeConvertUtil.str2dateTime(bo.getPlanstarttime());
        Timestamp endTime = TimeConvertUtil.str2dateTime(bo.getPlanstoptime());
        taskinfo.setPlanStartTime(startTime);
        taskinfo.setPlanEndTime(endTime);
        return taskinfoMapper.updateByTaskId(taskinfo);
    }

    /**
     * 删除任务
     * @param taskid
     * @param distrisign
     * @return
     */
    public Integer deleteTask(Integer taskid,Integer distrisign){
        return taskinfoMapper.deleteByTaskid(taskid,distrisign);
    }

    /**
     * 发布任务 + 撤回任务
     * @param taskid
     * @param distrisign
     * @return
     */
    public Integer updateDistrisign(Integer taskid,Integer distrisign){
        taskinfoMapper.updateFlagByTaskId(taskid,distrisign);
        return distrisign;
    }








}