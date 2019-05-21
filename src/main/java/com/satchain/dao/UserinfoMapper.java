package com.satchain.dao;

import com.satchain.bean.model.Userinfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserinfoMapper {

    int insert(@Param("username") String username, @Param("password") String password, @Param("permission") Integer permission, @Param("createTime") Date createTime);

    int insertSelective(Userinfo record);

    List<Userinfo> queryUserInfoByName(@Param("username") String username);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByUserName(@Param("username") String username, @Param("password") String password, @Param("createTime") Date createTime, @Param("permission") Integer permission);

    int deleteByUserName(@Param("username") String username);
}