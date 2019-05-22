package com.satchain.dao;

import com.satchain.bean.model.DeviceRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceRelationMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DeviceRelation record);

    int insertSelective(DeviceRelation record);

    List<DeviceRelation> selectBySatelliteUuid(@Param("satelliteUuid") String satelliteUuid);

    int updateByPrimaryKeySelective(DeviceRelation record);

    int updateByPrimaryKey(DeviceRelation record);
}