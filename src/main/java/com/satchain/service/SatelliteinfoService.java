package com.satchain.service;

import com.satchain.bean.model.Satelliteinfo;
import com.satchain.bean.vo.SatelliteInfoVO;
import com.satchain.dao.SatelliteinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SatelliteinfoService {
    @Autowired
    private SatelliteinfoMapper satelliteinfoMapper;


    /**
     * 27卫星信息查询
     * @param satelliteId
     * @param satelliteName
     * @return
     */
    public List<SatelliteInfoVO> querySatelliteInfo(String satelliteId, String satelliteName) {
        List<Satelliteinfo> satelliteinfos = satelliteinfoMapper.selectBySatelliteId(satelliteId,satelliteName);

        List<SatelliteInfoVO> satelliteInfoVOS = new ArrayList<>();
        for (Satelliteinfo sat : satelliteinfos){
            SatelliteInfoVO satelliteInfoVO = new SatelliteInfoVO();
            satelliteInfoVO.setSatelliteId(sat.getSatelliteUuid());
            satelliteInfoVO.setNasaId(sat.getNasaUuid());
            satelliteInfoVO.setConstellationId(sat.getConstellationType());
            satelliteInfoVO.setSatelliteType(sat.getSatelliteType());
            satelliteInfoVO.setTelemetryFre(sat.getTelemetryFrequency());
            satelliteInfoVO.setTelemetryErp(sat.getTelemetryErp());
            satelliteInfoVO.setTelecontrolFre(sat.getTelecontrolFrequency());
            satelliteInfoVO.setTelecontrolGain(sat.getTelecontrolReceivingGain());
            satelliteInfoVO.setDataDownFre(sat.getDataDownlinkFrequency());
            satelliteInfoVO.setDataDownErp(sat.getDataDownlinkErp());
            satelliteInfoVO.setDataUpFre(sat.getDataUplinkFrequency());
            satelliteInfoVO.setDataUpGain(sat.getDataUplinkReceivingGain());
            satelliteInfoVO.setBusinessDownFre(sat.getBusinessDownlinkFrequency());
            satelliteInfoVO.setBusinessDownErp(sat.getBusinessDownlinkErp());
            satelliteInfoVO.setBusinessUpFre(sat.getBusinessUplinkFrequency());
            satelliteInfoVO.setBusinessUpGain(sat.getBusinessUplinkReceivingGain());
            satelliteInfoVO.setDipAngle(sat.getDipAngle());
            satelliteInfoVO.setChek(sat.getEquatorialRadius());
            satelliteInfoVO.setEccentricity(sat.getEccentricity());
            satelliteInfoVO.setSemiMajorAxis(sat.getMajorSemiaxis());
            satelliteInfoVO.setPerigeeAngle(sat.getPerigeeAngularDistance());
            satelliteInfoVO.setPerigeeTime(sat.getPerigeeMoment());
            satelliteInfoVOS.add(satelliteInfoVO);
        }
        return satelliteInfoVOS;
    }

    /**
     * 28 新增卫星信息
     * @param bo
     * @return
     */
    public Integer insertSatellite(SatelliteInfoVO bo) throws Exception {
        if (satelliteinfoMapper.selectBySatelliteId(bo.getSatelliteId(),null).size()>0){
            throw new Exception("卫星信息已存在！");
        }

        Satelliteinfo satelliteinfo = new Satelliteinfo();
        satelliteinfo.setSatelliteUuid(bo.getSatelliteId());
        satelliteinfo.setNasaUuid(bo.getNasaId());
        satelliteinfo.setConstellationType(bo.getConstellationId());
        satelliteinfo.setSatelliteType(bo.getSatelliteType());
        satelliteinfo.setTelemetryFrequency(bo.getTelemetryFre());
        satelliteinfo.setTelemetryErp(bo.getTelemetryErp());
        satelliteinfo.setTelecontrolFrequency(bo.getTelecontrolFre());
        satelliteinfo.setTelecontrolReceivingGain(bo.getTelecontrolGain());
        satelliteinfo.setDataDownlinkFrequency(bo.getDataDownFre());
        satelliteinfo.setDataDownlinkErp(bo.getDataDownErp());
        satelliteinfo.setDataUplinkFrequency(bo.getDataUpFre());
        satelliteinfo.setDataUplinkReceivingGain(bo.getDataUpGain());
        satelliteinfo.setBusinessDownlinkFrequency(bo.getBusinessDownFre());
        satelliteinfo.setBusinessDownlinkErp(bo.getBusinessDownErp());
        satelliteinfo.setBusinessUplinkFrequency(bo.getBusinessUpFre());
        satelliteinfo.setBusinessUplinkReceivingGain(bo.getBusinessUpGain());
        satelliteinfo.setDipAngle(bo.getDipAngle());
        satelliteinfo.setEquatorialRadius(bo.getChek());
        satelliteinfo.setEccentricity(bo.getEccentricity());
        satelliteinfo.setMajorSemiaxis(bo.getSemiMajorAxis());
        satelliteinfo.setPerigeeAngularDistance(bo.getPerigeeAngle());
        satelliteinfo.setPerigeeMoment(bo.getPerigeeTime());

        return satelliteinfoMapper.insert(satelliteinfo);
    }

    public Integer deleteSatelliteInfo(String satelliteId, String satelliteName) {
        return satelliteinfoMapper.deleteByIdName(satelliteId,satelliteName);
    }

    public Integer updateSatelliteInfo(SatelliteInfoVO bo) throws Exception {

        if (satelliteinfoMapper.selectBySatelliteId(bo.getSatelliteId(),null).size()<=0){
            throw new Exception("卫星信息不存在！");
        }

        Satelliteinfo satelliteinfo = new Satelliteinfo();
        satelliteinfo.setSatelliteUuid(bo.getSatelliteId());
        satelliteinfo.setNasaUuid(bo.getNasaId());
        satelliteinfo.setSatelliteName(bo.getSatelliteName());
        satelliteinfo.setConstellationType(bo.getConstellationId());
        satelliteinfo.setSatelliteType(bo.getSatelliteType());
        satelliteinfo.setTelemetryFrequency(bo.getTelemetryFre());
        satelliteinfo.setTelemetryErp(bo.getTelemetryErp());
        satelliteinfo.setTelecontrolFrequency(bo.getTelecontrolFre());
        satelliteinfo.setTelecontrolReceivingGain(bo.getTelecontrolGain());
        satelliteinfo.setDataDownlinkFrequency(bo.getDataDownFre());
        satelliteinfo.setDataDownlinkErp(bo.getDataDownErp());
        satelliteinfo.setDataUplinkFrequency(bo.getDataUpFre());
        satelliteinfo.setDataUplinkReceivingGain(bo.getDataUpGain());
        satelliteinfo.setBusinessDownlinkFrequency(bo.getBusinessDownFre());
        satelliteinfo.setBusinessDownlinkErp(bo.getBusinessDownErp());
        satelliteinfo.setBusinessUplinkFrequency(bo.getBusinessUpFre());
        satelliteinfo.setBusinessUplinkReceivingGain(bo.getBusinessUpGain());
        satelliteinfo.setDipAngle(bo.getDipAngle());
        satelliteinfo.setEquatorialRadius(bo.getChek());
        satelliteinfo.setEccentricity(bo.getEccentricity());
        satelliteinfo.setMajorSemiaxis(bo.getSemiMajorAxis());
        satelliteinfo.setPerigeeAngularDistance(bo.getPerigeeAngle());
        satelliteinfo.setPerigeeMoment(bo.getPerigeeTime());
        return satelliteinfoMapper.updateByIdSelective(satelliteinfo);
    }

    /**
     * 31 查詢星座下的所有卫星
     * @param constellationId
     * @return
     */
    public List<Map<String,String>> querySatelliteInfoByConstrllationID(String constellationId) {
        List<Satelliteinfo> satelliteinfos = satelliteinfoMapper.queryBySateOrConstID(null,constellationId);

        List<Map<String,String>> mapList = new ArrayList<>();
        for (Satelliteinfo sat : satelliteinfos){
            Map<String,String> map = new HashMap<>();
            map.put("satelliteId",sat.getSatelliteUuid());
            map.put("satelliteName",sat.getSatelliteName());
            mapList.add(map);
        }

        return mapList;
    }
}
