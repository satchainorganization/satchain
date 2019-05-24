package com.satchain.controller.web;

import com.satchain.bean.bo.AddTaskBO;
import com.satchain.bean.bo.QueryTaskBO;
import com.satchain.bean.vo.TaskInfoVO;
import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.myEnum.TaskinfoDatadistrisignEnum;
import com.satchain.commons.result.Result;
import com.satchain.service.TaskAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 任务分配表：增删改查
 */
@RestController
public class TaskAssignmentController {

    @Autowired
    TaskAssignmentService taskAssignmentService;

    /**
     * 查询任务
     * @return
     */
    @RequestMapping(value = "/queryTaskAssignment", method = RequestMethod.POST)
    public Result queryTask(QueryTaskBO queryTaskBO) {
        Assert.notNull(queryTaskBO,"参数错误！");
        List<TaskInfoVO> taskinfoList = taskAssignmentService.queryTask(queryTaskBO);
        return Result.success(taskinfoList);
    }

    /**
     * 新增任务
     * @return
     */
    @RequestMapping(value = "/addTaskAssignment", method = RequestMethod.POST)
    public Result addTask(AddTaskBO bo) {
        Assert.notNull(bo,"参数错误！");
        Assert.notNull(bo.getGroundid(),"地面站编号不能为空！");
        Assert.notNull(bo.getSatelliteid(),"卫星编号不能为空！");
        Assert.notNull(bo.getTasktype(),"类型不能为空！");
        Assert.notNull(bo.getPlanstarttime(),"开始时间不能为空！");
        Assert.notNull(bo.getPlanendtime(),"结束时间不能为空！");

        int num = taskAssignmentService.addTask(bo);
        //Assert.isTrue(num != 0,"插入失败！");
        if(num == 0){
            return Result.failure(ResponseCodeEnum.ERROR,"新增任务失败！");
        }
        return Result.success();
    }

    /**
     * 修改任务
     * @return
     */
    @RequestMapping(value = "/updateTask", method = RequestMethod.POST)
    public Result updateTask(QueryTaskBO bo) throws Exception {
        Assert.notNull(bo,"参数错误！");
        Assert.notNull(bo.getTaskid(),"参数错误！");
        int num = taskAssignmentService.updateTask(bo);
        if(num == 0){
            return Result.failure(ResponseCodeEnum.ERROR,"更新失败！");
        }
        return Result.success();
    }

    /**
     * 删除任务
     * @return
     */
    @RequestMapping(value = "/deleteTask", method = RequestMethod.DELETE)
    public Result deleteTask(@RequestParam("taskid") Integer taskid,
                             @RequestParam("distrisign") Integer distrisign) {
        Assert.notNull(taskid,"参数错误！");
        int num = taskAssignmentService.deleteTask(taskid,distrisign);
        if(num == 0){
            return Result.failure(ResponseCodeEnum.ERROR,"删除失败，数据不存在！");
        }
        return Result.success();
    }

    /**
     * 发布任务
     * @return
     */
    @RequestMapping(value = "/taskPublish", method = RequestMethod.POST)
    public Result taskPublish(@RequestParam("taskid") Integer taskid, @RequestParam("datadistrisign") Boolean datadistrisign) {
        Assert.notNull(taskid,"任务编号不能为空！");
        Assert.notNull(datadistrisign,"参数错误！");
        Integer dataDistrisign = datadistrisign ? 1 : 0;
        int num = taskAssignmentService.updateDistrisign(taskid,dataDistrisign);
        if(num == 0){
            return Result.failure(ResponseCodeEnum.ERROR,"发布任务失败，数据不存在！");
        }
        return Result.success();
    }

    /**
     * 撤回任务
     * @return
     */
    @RequestMapping(value = "/cancelTask", method = RequestMethod.POST)
    public Result cancelTask(@RequestParam("taskid") Integer taskid) {
        Assert.notNull(taskid,"任务编号不能为空！");
        int num = taskAssignmentService.updateDistrisign(taskid, TaskinfoDatadistrisignEnum.NOT_PUBLISH.getCode());
        if(num == 0){
            return Result.failure(ResponseCodeEnum.ERROR,"任务撤回失败，数据不存在！");
        }
        return Result.success();
    }



    /**
     * 3.11设备列表读取
     * */

    /**
     * 3.12字段定义表读取
     * */

    /**
     * 3.13遥测数据表读取
     */

    /**
     * 3.14下行数据查询
     */

    /**
     * 3.15上传数据
     */
    /**
     * 3.16上行数据查询
     */






    //TODO 37 38 39

}
