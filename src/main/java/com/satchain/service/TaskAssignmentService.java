package com.satchain.service;

import com.satchain.bean.bo.AddTaskBO;
import com.satchain.bean.bo.QueryTaskBO;
import com.satchain.bean.model.Earthinfo;
import com.satchain.bean.model.Satelliteinfo;
import com.satchain.bean.model.Taskinfo;
import com.satchain.bean.vo.TaskInfoVO;
import com.satchain.dao.EarthinfoMapper;
import com.satchain.dao.SatelliteinfoMapper;
import com.satchain.dao.TaskinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
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

    @Autowired
    private EarthinfoMapper earthinfoMapper;

    /**
     * 3 查询任务
     * @param bo
     * @return
     */
    public List<TaskInfoVO> queryTask(QueryTaskBO bo){
        Date startTime = null;
        Date endTime = null;
        try {
            if (bo.getPlanstarttime() != null){
                startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(bo.getPlanstarttime());
            }
            if (bo.getPlanstoptime() != null){
                endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(bo.getPlanstoptime());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<String> satId = new ArrayList<>();
        if (bo.getConstellationid()!=null && bo.getSatelliteid()==null){
            List<Satelliteinfo> satelliteinfos = satelliteinfoMapper.queryBySateOrConstID(null, bo.getConstellationid());
            for (Satelliteinfo sat : satelliteinfos){
                satId.add(sat.getSatelliteUuid());
            }
        }
        if (bo.getSatelliteid()!=null && bo.getSatelliteid() != ""){
            satId.add(bo.getSatelliteid());
        }

        List<Taskinfo> taskinfoList = null;
        if (StringUtils.isEmpty(bo.getSatelliteid()) && StringUtils.isEmpty(bo.getConstellationid())){
            taskinfoList = taskinfoMapper.queryTaskInfoByTaskBO(null,bo.getTasktype(),bo.getDistrisign(),startTime,endTime);
        }else{
            taskinfoList = taskinfoMapper.queryTaskInfoByTaskBO(satId,bo.getTasktype(),bo.getDistrisign(),startTime,endTime);
        }

        List<TaskInfoVO> taskInfoVOS = new ArrayList<>();
        for (Taskinfo taskinfo : taskinfoList){
            TaskInfoVO taskInfoVO = new TaskInfoVO();
            taskInfoVO.setTaskid(taskinfo.getTaskUuid());
            String publishTime = null;
            if (taskinfo.getTaskReleaseTime() != null){
                publishTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(taskinfo.getTaskReleaseTime());
                taskInfoVO.setPublishTime(publishTime);
            }
            taskInfoVO.setSatelliteid(taskinfo.getSatelliteUuid());
            taskInfoVO.setGroundid(taskinfo.getEarthUuid());
            taskInfoVO.setTasktype(taskinfo.getTaskType());
            String planstarttime = null;
            if (taskinfo.getPlanStartTime() != null){
                planstarttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(taskinfo.getPlanStartTime());
                taskInfoVO.setPlanstartime(planstarttime);
            }
            String planendtime = null;
            if (taskinfo.getPlanEndTime() != null){
                planendtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(taskinfo.getPlanEndTime());
                taskInfoVO.setPlanendtime(planendtime);
            }
            String taskstarttime = null;
            if (taskinfo.getTaskStartTime() != null){
                taskstarttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(taskinfo.getTaskStartTime());
                taskInfoVO.setPlanstartime(taskstarttime);
            }
            String taskendtime = null;
            if (taskinfo.getTaskEndTime()!=null){
                taskendtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(taskinfo.getTaskEndTime());
                taskInfoVO.setPlanendtime(taskendtime);
            }
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
        /*Timestamp startTime = TimeConvertUtil.str2dateTime(bo.getPlanstarttime());
        Timestamp endTime = TimeConvertUtil.str2dateTime(bo.getPlanendtime());*/
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(bo.getPlanstarttime());
            endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(bo.getPlanendtime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Earthinfo> earthinfos =  earthinfoMapper.queryEarthInfoByGroundId(bo.getGroundid());
        if (earthinfos.size() <= 0) {
           return -1;
        }
        List<Satelliteinfo> satelliteinfos = satelliteinfoMapper.queryBySateOrConstID(bo.getSatelliteid(), null);
        if (satelliteinfos.size()<=0){
            return -2;
        }

        Taskinfo taskinfo = new Taskinfo();
        taskinfo.setEarthUuid(bo.getGroundid());
        taskinfo.setSatelliteUuid(bo.getSatelliteid());
        taskinfo.setTaskType(bo.getTasktype());
        taskinfo.setPlanStartTime(startTime);
        taskinfo.setPlanEndTime(endTime);
        taskinfo.setTaskFlag(false);
        taskinfo.setDistributionFlag(0);
        taskinfoMapper.insert(taskinfo);
        return taskinfo.getTaskUuid();

    }

    /**
     * 更新任务
     * @param bo
     */
    public Integer updateTask(QueryTaskBO bo) throws Exception {

        if (taskinfoMapper.selectByTaskId(bo.getTaskid()) == null){
            //throw new Exception("数据不存在！");
            return -1;
        }
        Taskinfo taskinfo = new Taskinfo();
        taskinfo.setTaskUuid(bo.getTaskid());
        taskinfo.setSatelliteUuid(bo.getSatelliteid());
        taskinfo.setTaskType(bo.getTasktype());

        Date startTime = null;
        Date endTime = null;
        try {
            if (bo.getPlanstarttime() != null){
                startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(bo.getPlanstarttime());

            }
            if (bo.getPlanstoptime() != null){
                endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(bo.getPlanstoptime());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        taskinfo.setPlanStartTime(startTime);
        taskinfo.setPlanEndTime(endTime);
        taskinfo.setDistributionFlag(0);
        return taskinfoMapper.updateByTaskId(taskinfo);
    }

    /**
     * 删除任务
     * @param taskid
     * @param distrisign
     * @return
     */
    public Integer deleteTask(Integer taskid,Integer distrisign){
        Taskinfo taskinfo = taskinfoMapper.selectByTaskId(taskid);
        if (taskinfo.getDistributionFlag() == 0){
            return taskinfoMapper.deleteByTaskid(taskid,distrisign);
        }
        return 0;
    }

    /**
     * 发布任务
     * @param taskid
     * @param distrisign
     * @return
     */
    public Integer updateDistrisign(Integer taskid,Integer distrisign){
        Taskinfo taskinfo = taskinfoMapper.selectByTaskId(taskid);
        Date now = new Date();
        /*String now = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        Date nowTime = null;
        try {
            nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(now);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        if (taskinfo != null && taskinfo.getDistributionFlag() == 0){
            return taskinfoMapper.updateFlagByTaskId(taskid,distrisign,now);
        }
        return 0;
    }

    /**
     * 撤销任务
     * @param taskid
     * @param distrisign
     * @return
     */
    public Integer cancelDistrisgin(Integer taskid,Integer distrisign){
        Taskinfo taskinfo = taskinfoMapper.selectByTaskId(taskid);
        if (taskinfo.getDistributionFlag() == 2 && taskinfo.getTaskFlag() == false){
            return taskinfoMapper.updateFlagByTaskId(taskid,distrisign,null);
        }
        return 0;
    }








}