package com.satchain.service;

import com.satchain.bean.model.DeviceRelation;
import com.satchain.dao.DeviceRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceRelationService {

    @Autowired
    private DeviceRelationMapper deviceRelationMapper;

    /**
     * 设备关系表读取
     * @param satelliteId
     * @return
     */
    public List<Map<String, String>> queryDevice(String satelliteId) {

        List<Map<String, String>> list = new ArrayList<>();

        List<DeviceRelation> deviceRelations =  deviceRelationMapper.selectBySatelliteUuid(satelliteId);
        for (DeviceRelation dev : deviceRelations){
            Map<String, String> map = new HashMap<String, String>();
            map.put("deviceName",dev.getDeviceName());
            map.put("parentName",dev.getDeviceFartherName());
            list.add(map);
        }
        return list;
    }
}
