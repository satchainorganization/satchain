package com.satchain.service;

import com.satchain.bean.model.Monitorinfo;
import com.satchain.bean.vo.MonitorInfoVO;
import com.satchain.dao.MonitorinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonitorinfoService {
    @Autowired
    private MonitorinfoMapper monitorinfoMapper;

    /**
     * 3.40 添加监控器
     * @param monitorStation
     * @param monitorUuid
     * @param monitorUri
     * @return
     */
    public Integer addMonitorInfo(String monitorStation, String monitorUuid, String monitorUri) throws Exception {
        List<Monitorinfo> monitorinfos = monitorinfoMapper.selectById(monitorUuid, null);
        if (monitorinfos.size()>0){
            throw new Exception("添加失败，监视器已存在！");
        }
        Monitorinfo bo = new Monitorinfo();
        bo.setMonitorUuid(monitorUuid);
        bo.setMonitorPosition(monitorStation);
        bo.setMonitorIp(monitorUri);
        return monitorinfoMapper.insert(bo);
    }

    /**
     * 3.41 queryMonitor查询监控器
     * @param monitorId
     * @param monitorStation
     * @return
     */
    public List<MonitorInfoVO> queryMonitorInfo(String monitorId, String monitorStation) {
        List<Monitorinfo> monitorinfos = monitorinfoMapper.selectById(monitorId,monitorStation);

        List<MonitorInfoVO> monitorInfoVOS = new ArrayList<>();
        for(Monitorinfo mon : monitorinfos){
            MonitorInfoVO monitorInfoVO = new MonitorInfoVO();
            monitorInfoVO.setMonitorid(mon.getMonitorUuid());
            monitorInfoVO.setMonitorStation(mon.getMonitorPosition());
            monitorInfoVO.setMonitorUri(mon.getMonitorIp());
            monitorInfoVOS.add(monitorInfoVO);
        }
        return monitorInfoVOS;
    }

    /**
     * 3.42	deleteMonitor删除监控器
     * @param monitorId
     * @return
     */
    public Integer deleteMonitorInfo(String monitorId) {
        return monitorinfoMapper.deleteById(monitorId);
    }

    /**
     * 3.43	editMonitor编辑监控器
     * @param monitorId
     * @param monitorStation
     * @param monitorUrl
     */
    public Integer updateMonitorInfo(String monitorId, String monitorStation, String monitorUrl) throws Exception {
        List<Monitorinfo> monitorinfos = monitorinfoMapper.selectById(monitorId,null);
        if (monitorinfos.size() <= 0){
            throw new Exception("编辑失败，监视器不存在！");
        }
        return monitorinfoMapper.updateByIdSelective(monitorId,monitorStation,monitorUrl);
    }
}
