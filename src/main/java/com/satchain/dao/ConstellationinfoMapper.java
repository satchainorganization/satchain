package com.satchain.dao;

import com.satchain.bean.model.Constellationinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 星座信息表
 */

public interface ConstellationinfoMapper {

    int deleteById(@Param("constellationUuid") String constellationUuid, @Param("constellationName") String constellationName);

    int insert(Constellationinfo record);

    int insertSelective(Constellationinfo record);


    Constellationinfo selectById(@Param("constellationId") String constellationId);

    List<Constellationinfo> selectAll();

    int updateByIdSelective(Constellationinfo record);

    List<Constellationinfo> selectByIdAndName(@Param("constellationUuid") String constellationUuid,
                                        @Param("constellationName") String constellationName);
}