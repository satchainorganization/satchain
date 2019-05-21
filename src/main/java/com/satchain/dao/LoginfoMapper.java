package com.satchain.dao;

import com.satchain.bean.model.Loginfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface LoginfoMapper {

    int deleteByTime(@Param("startTime") Date startTime, @Param("stopTime") Date stopTime);

    int insert(Loginfo record);

    int insertSelective(Loginfo record);


    List<Loginfo> queryLogByTime(@Param("startTime") Date startTime, @Param("stopTime") Date stopTime);

    Loginfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Loginfo record);

    int updateByPrimaryKey(Loginfo record);
}