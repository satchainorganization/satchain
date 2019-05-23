package com.satchain.dao;

import com.satchain.bean.model.Monitorinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MonitorinfoMapper {

    int deleteById(@Param("monitorId") String monitorId);

    int insert(Monitorinfo record);

    int insertSelective(Monitorinfo record);

    List<Monitorinfo> selectById(@Param("monitorUuid") String monitorUuid, @Param("monitorStation") String monitorStation);

    int updateByIdSelective(@Param("monitorUuid") String monitorUuid, @Param("monitorStation") String monitorStation,
                            @Param("monitorUrl") String monitorUrl);

    int updateByPrimaryKey(Monitorinfo record);
}