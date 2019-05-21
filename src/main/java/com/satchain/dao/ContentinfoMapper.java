package com.satchain.dao;

import com.satchain.bean.model.Contentinfo;
import org.apache.ibatis.annotations.Param;

/**
 * 遥控内容表
 */
public interface ContentinfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Contentinfo record);

    int insertSelective(Contentinfo record);

    Contentinfo selectByTaskId(@Param("taskUuid") Integer taskUuid);

    int updateByPrimaryKeySelective(Contentinfo record);

    int updateByPrimaryKeyWithBLOBs(Contentinfo record);

    int updateByPrimaryKey(Contentinfo record);
}