package com.satchain.dao;

import com.satchain.bean.model.TelemetryData;
import com.satchain.bean.model.TelemetryDataExample;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface TelemetryDataMapper {

    List<HashMap<String,Object>> selectByTableName(@Param("tableName") String tableName);
}