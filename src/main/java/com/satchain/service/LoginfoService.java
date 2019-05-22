package com.satchain.service;

import com.satchain.bean.model.Loginfo;
import com.satchain.bean.vo.LogInfoVO;
import com.satchain.commons.utils.TimeConvertUtil;
import com.satchain.dao.LoginfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginfoService {
    @Autowired
    private LoginfoMapper loginfoMapper;

    /**
     * 日志查询
     * @param starttime
     * @param stoptime
     * @return
     */
    public List<LogInfoVO> queryLogInfo(String starttime, String stoptime){
        Timestamp startTime = TimeConvertUtil.str2dateTime(starttime);
        Timestamp stopTime = TimeConvertUtil.str2dateTime(stoptime);
        List<Loginfo> loginfoList = loginfoMapper.queryLogByTime(startTime,stopTime);

        List<LogInfoVO> logInfoVOS = new ArrayList<>();
        for (Loginfo log : loginfoList){
            LogInfoVO logInfoVO = new LogInfoVO();
            logInfoVO.setTime(TimeConvertUtil.date2String(log.getTime()));
            logInfoVO.setModule(log.getObjects());
            logInfoVO.setEvent(log.getParameter());
            logInfoVOS.add(logInfoVO);
        }
        return logInfoVOS;
    }

    public int deleteLogInfo(String starttime,String stoptime){
        Timestamp startTime = TimeConvertUtil.str2dateTime(starttime);
        Timestamp stopTime = TimeConvertUtil.str2dateTime(stoptime);
        return loginfoMapper.deleteByTime(startTime,stopTime);
    }

    public int insertLogInfo(Loginfo loginfo) {

        return loginfoMapper.insert(loginfo);
    }
}
