package com.satchain.service;

import com.satchain.bean.model.Earthinfo;
import com.satchain.bean.vo.EarthInfoVO;
import com.satchain.dao.EarthinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 地面站信息表：增删改查
 */
@Service
public class EarthinfoService {
    @Autowired
    private EarthinfoMapper earthinfoMapper;

    /**
     * 查询地面站信息
     * @param groundId
     * @return
     */
    public List<EarthInfoVO> queryEarthInfo(String groundId) {
        List<Earthinfo> earthinfos = earthinfoMapper.queryEarthInfoByGroundId(groundId);

        List<EarthInfoVO> earthInfoVOS = new ArrayList<>();
        for (Earthinfo earth : earthinfos){
            EarthInfoVO earthInfoVO = new EarthInfoVO();
            earthInfoVO.setGroundId(earth.getGroundId());
            earthInfoVO.setGroundName(earth.getGroundName());
            earthInfoVO.setGroundType(earth.getGroundType());
            earthInfoVO.setGroundTelemetryFre(earth.getGroundTelemetryFre());
            earthInfoVO.setGroundTelemetryGain(earth.getGroundTelemetryGain());
            earthInfoVO.setGroundTelecontrolErp(earth.getGroundTelecontrolErp());
            earthInfoVO.setGroundTelecontrolFre(earth.getGroundTelecontrolFre());
            earthInfoVO.setDataDownFre(earth.getDataDownFre());
            earthInfoVO.setDataDownGain(earth.getDataDownGain());
            earthInfoVO.setDataUpFre(earth.getDataUpFre());
            earthInfoVO.setDataUpErp(earth.getDataUpErp());
            earthInfoVO.setLon(earth.getLon());
            earthInfoVO.setLat(earth.getLat());
            earthInfoVO.setIp(earth.getIp());
            earthInfoVOS.add(earthInfoVO);
        }
        return earthInfoVOS;
    }

    /**
     * 新增地面站
     * @param bo
     * @return
     */
    public Integer insertEarthInfo(Earthinfo bo) throws Exception {
        List<Earthinfo> earthinfo = earthinfoMapper.queryEarthInfoByGroundId(bo.getGroundId());
        if (earthinfo.size() > 0){
            throw new Exception("新增地面站已经存在！");
        }
        return earthinfoMapper.insert(bo);
    }

    /**
     * 删除地面站信息
     * @param groundId
     */
    public Integer deleteEarthInfo(String groundId) {
        return earthinfoMapper.deleteByGroundId(groundId);
    }

    /**
     * 修改地面站信息
     * @param bo
     */
    public Integer updateEarthInfo(Earthinfo bo) throws Exception {
        List<Earthinfo> earthinfo = earthinfoMapper.queryEarthInfoByGroundId(bo.getGroundId());
        if (earthinfo.size() <= 0){
            throw new Exception("地面站不存在！");
        }
        return earthinfoMapper.updateByGroundId(bo);
    }

}
