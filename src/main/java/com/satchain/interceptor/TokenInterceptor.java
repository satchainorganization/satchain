package com.satchain.interceptor;

import com.alibaba.fastjson.JSON;
import com.satchain.bean.model.Userinfo;
import com.satchain.bean.vo.UserInfoVO;
import com.satchain.commons.constants.Constants;
import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.myEnum.UserRoleEnum;
import com.satchain.commons.result.Result;
import com.satchain.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 董少飞
 * // TODO: 2019/5/19 dsf
 * @date 2019/5/19
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserinfoService userinfoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
/*
        String username = (String) request.getAttribute(Constants.SESSION_USERNAME_KEY);
        List<UserInfoVO> userInfoVOList = userinfoService.queryUserInfo(username);

        if(request.getRequestURI().equals(Constants.ADD_USER_URL) && !userInfoVOList.get(0).getPermission().equals(UserRoleEnum.ADMIN.key)) {

            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.print(JSON.toJSONString(Result.failure(ResponseCodeEnum.PERMISSION_DENY)));
            return false;
        }*/
        return true;
    }

}
