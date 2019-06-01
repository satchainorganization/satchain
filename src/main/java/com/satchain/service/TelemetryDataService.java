package com.satchain.service;

import com.alibaba.fastjson.JSON;
import com.satchain.commons.utils.JSONUtils;
import com.satchain.dao.TelemetryDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TelemetryDataService {
    @Autowired
    private TelemetryDataMapper telemetryDataMapper;

    public HashMap<String,Object> queryTeleData(String satelliteId,String deviceName){
        String tableName = satelliteId + deviceName;
        HashMap<String,Object> hashMap = telemetryDataMapper.selectByTableName(tableName);
        return hashMap;
    }
}
