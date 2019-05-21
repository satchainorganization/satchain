package com.satchain.service;

import com.satchain.bean.model.Userinfo;
import com.satchain.bean.vo.UserChangeVO;
import com.satchain.bean.vo.UserInfoVO;
import com.satchain.commons.utils.TimeConvertUtil;
import com.satchain.dao.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户信息：增删改查
 */
@Service
public class UserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    public Integer insertUser(String username, String password, Integer permission) {
        return userinfoMapper.insert(username,password,permission,new Date());
    }

    /**
     * 查询用户信息
     * @param username
     * @return
     */
    public List<UserInfoVO> queryUserInfo(String username) {
        List<Userinfo> userinfo = userinfoMapper.queryUserInfoByName(username);

        List<UserInfoVO> userInfoVOS = new ArrayList<>();
        for (Userinfo user : userinfo){
            UserInfoVO userInfoVO = new UserInfoVO();
            userInfoVO.setUsername(user.getUserName());
            //对密码加密处理
            String password = user.getPassword();
            String psw=DigestUtils.md5DigestAsHex(password.getBytes());
            userInfoVO.setPassword(psw);
            userInfoVO.setCreateTime(TimeConvertUtil.date2String(user.getCreateTime()));
            userInfoVO.setPermission(user.getAuthority());
            userInfoVOS.add(userInfoVO);
        }
        return userInfoVOS;
    }

    /**
     * 编辑用户信息
     * @param username
     * @param password
     * @param permission
     */
    public UserChangeVO updateUserInfo(String username, String password, String createTime, Integer permission) throws ParseException {

        Timestamp time = null;
        if (createTime != null){
            time = TimeConvertUtil.str2dateTime(createTime);
        }
        int edit = userinfoMapper.updateByUserName(username,password,time,permission);
        UserChangeVO userChangeVO = new UserChangeVO();
        if (edit != 0){
            userChangeVO.setUsername(username);
            userChangeVO.setNewpassword(password);
            userChangeVO.setNewpermission(permission);
        }
        return userChangeVO;
    }

    /**
     * 删除用户信息
     * @param username
     */
    public Integer deleteUserInfo(String username) {
        return userinfoMapper.deleteByUserName(username);
    }

}
