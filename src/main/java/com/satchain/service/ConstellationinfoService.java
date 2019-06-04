package com.satchain.service;

import com.satchain.bean.model.Constellationinfo;
import com.satchain.bean.vo.ConstellationinfoVO;
import com.satchain.dao.ConstellationinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 星座信息表
 */
@Service
public class ConstellationinfoService {

    @Autowired
    private ConstellationinfoMapper constellationinfoMapper;

    /**
     * 查询全部星座
     * @return
     */
    public List<ConstellationinfoVO> queryConstellationInfoList() {
        List<Constellationinfo> constellationinfos = constellationinfoMapper.selectAll();

        List<ConstellationinfoVO> constellationinfoVOS = new ArrayList<>();
        for (Constellationinfo con : constellationinfos){
            ConstellationinfoVO constellationinfoVO = new ConstellationinfoVO();
            constellationinfoVO.setConstellationId(con.getConstellationUuid());
            constellationinfoVO.setConstellationName(con.getConstellationName());
            constellationinfoVO.setConstellationType(con.getConstellationType());
            constellationinfoVO.setConstellationOwners(con.getUserName());
            constellationinfoVOS.add(constellationinfoVO);
        }
        return constellationinfoVOS;
    }

    /**
     * 3.33 queryConstellation查询星座信息
     * @param constellationId
     * @return
     */
    public ConstellationinfoVO queryConstellationInfo(String constellationId) {
        Constellationinfo con = constellationinfoMapper.selectById(constellationId);
        ConstellationinfoVO constellationinfoVO = new ConstellationinfoVO();
        if(con != null){
            constellationinfoVO.setConstellationId(con.getConstellationUuid());
            constellationinfoVO.setConstellationName(con.getConstellationName());
            constellationinfoVO.setConstellationType(con.getConstellationType());
            constellationinfoVO.setConstellationOwners(con.getUserName());
        }
        return constellationinfoVO;
    }

    /**
     * 34 新增星座
     * @param constellationId
     * @param constellationName
     * @param constellationType
     * @param constellationOwners
     * @return
     */
    public Integer addConstellationInfo(String constellationId,String constellationName,Integer constellationType, String constellationOwners) throws Exception {
        Constellationinfo con = constellationinfoMapper.selectById(constellationId);
        if(con != null ) {
            return 0;
            //throw new Exception("添加失败，星座已经存在！");
        }
        Constellationinfo constellationinfo = new Constellationinfo();
        constellationinfo.setConstellationUuid(constellationId);
        constellationinfo.setConstellationName(constellationName);
        constellationinfo.setConstellationType(constellationType);
        constellationinfo.setUserName(constellationOwners);
        return constellationinfoMapper.insert(constellationinfo);
    }

    /**
     * 35 删除星座
     * @param
     * @param constellationName
     * @return
     */
    public Integer deleteConstellationInfo(String constellationUuid,String constellationName) {
        List<Constellationinfo> con = constellationinfoMapper.selectByIdAndName(constellationUuid,constellationName);
        if (con.size()<=0){
            return 0;
        }
        int deleteResult = constellationinfoMapper.deleteById(constellationUuid,constellationName);
        return deleteResult;
    }

    /**
     * 36 更改星座
     * @param constellationId
     * @param constellationName
     * @param constellationType
     * @param constellationOwners
     * @return
     */
    public Integer updateConstellationInfo(String constellationId,String constellationName,Integer constellationType, String constellationOwners) {

        Constellationinfo constellationinfo = new Constellationinfo();

        constellationinfo.setConstellationUuid(constellationId);
        constellationinfo.setConstellationName(constellationName);
        constellationinfo.setConstellationType(constellationType);
        constellationinfo.setUserName(constellationOwners);
        return constellationinfoMapper.updateByIdSelective(constellationinfo);
    }

}
