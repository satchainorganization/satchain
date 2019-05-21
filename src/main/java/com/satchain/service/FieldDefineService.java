package com.satchain.service;

import com.satchain.bean.model.FieldDefine;
import com.satchain.bean.vo.FieldVO;
import com.satchain.dao.FieldDefineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FieldDefineService {

    @Autowired
    private FieldDefineMapper fieldDefineMapper;

    /**
     * 3.12 字段定义表读取
     * @param satelliteId
     * @param deviceName
     * @return
     */
    public List<FieldVO> queryFieldByIdAndName(String satelliteId, String deviceName) {
        List<FieldVO> res = new ArrayList<>();
        List<FieldDefine> fieldDefines = fieldDefineMapper.selectByPrimaryKey(satelliteId,deviceName);
        for (FieldDefine fie : fieldDefines){
            FieldVO fieldVO = new FieldVO();
            fieldVO.setFieldName(fie.getFieldName());
            fieldVO.setType(fie.getDataType());
            fieldVO.setMin(fie.getMinData());
            fieldVO.setMax(fie.getMaxData());
            fieldVO.setUnit(fie.getUnit());
            fieldVO.setSign(fie.getShowLable());
            fieldVO.setDeviceName(fie.getDeviceName());
            res.add(fieldVO);
        }
        return res;
    }
}
