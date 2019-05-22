package com.satchain.service;

import com.satchain.bean.model.Userinfo;
import com.satchain.dao.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    public String getPassword(String loginName) {
        List<Userinfo> userinfoList = userinfoMapper.queryUserInfoByName(loginName);
        if(userinfoList.isEmpty()){
            return "";
        }else{
            return userinfoList.get(0).getPassword();
        }
    }
}
