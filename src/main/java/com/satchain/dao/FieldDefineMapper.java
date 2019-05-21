package com.satchain.dao;

import com.satchain.bean.model.FieldDefine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FieldDefineMapper {

    int deleteByPrimaryKey(Long id);

    int insert(FieldDefine record);

    int insertSelective(FieldDefine record);

    List<FieldDefine> selectByPrimaryKey(@Param("satelliteUuid") String satelliteUuid, @Param("deviceName") String deviceName);

    int updateByPrimaryKeySelective(FieldDefine record);

    int updateByPrimaryKey(FieldDefine record);
}