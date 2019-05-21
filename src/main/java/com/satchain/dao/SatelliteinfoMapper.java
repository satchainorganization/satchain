package com.satchain.dao;

import com.satchain.bean.model.Satelliteinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SatelliteinfoMapper {

    int insert(Satelliteinfo record);

    int updateByPrimaryKey(Satelliteinfo record);

    int updateByIdSelective(Satelliteinfo record);

    List<Satelliteinfo> selectBySatelliteId(@Param("satelliteUuid") String satelliteUuid, @Param("satelliteName") String satelliteName);

    int deleteByIdName(@Param("satelliteUuid") String satelliteUuid, @Param("satelliteName") String satelliteName);

    List<Satelliteinfo> queryBySateOrConstID(@Param("satelliteUuid") String satelliteUuid, @Param("constellationId") String constellationId);

}