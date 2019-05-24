package com.satchain.dao;

import com.satchain.bean.model.Taskinfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TaskinfoMapper {

    int deleteByTaskid(@Param("taskid") Integer taskid, @Param("distrisign") Integer distrisign);

    int insert(Taskinfo record);

    int insertReturn(Taskinfo record);

    Taskinfo selectByTaskId(@Param("taskid") Integer taskid);

    int updateByTaskId(Taskinfo record);

    int updateFlagByTaskId(@Param("taskid") Integer taskid, @Param("datadistrisign") Integer datadistrisign);

    List<Taskinfo> queryTaskInfoByTaskBO(@Param("satelliteUuid") List satelliteUuid,
                                         @Param("tasktype") Integer tasktype, @Param("distrisign") Integer distrisign,
                                         @Param("starttime") Date starttime, @Param("stoptime") Date stoptime);
    List<Taskinfo> queryTaskInfoByidAndTime(@Param("satelliteUuid") String satelliteUuid,
                                            @Param("starttime") Date starttime, @Param("stoptime") Date stoptime);

    List<Taskinfo> queryBySatelliteId(@Param("satelliteUuid") String satelliteUuid);
}