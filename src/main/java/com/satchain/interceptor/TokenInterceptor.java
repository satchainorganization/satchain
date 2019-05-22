package com.satchain.interceptor;

import com.alibaba.fastjson.JSON;
import com.satchain.bean.vo.UserInfoVO;
import com.satchain.commons.constants.Constants;
import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.myEnum.UserRoleEnum;
import com.satchain.commons.result.Result;
import com.satchain.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
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
        String username = (String) request.getSession().getAttribute(Constants.SESSION_USERNAME_KEY);
        if(username == null || "".equals(username)) {
            setResponse(response, Result.failure(ResponseCodeEnum.NO_LOGIN));
            return false;
        }
        List<UserInfoVO> userInfoVOList = userinfoService.queryUserInfo(username);

        if(CollectionUtils.isEmpty(userInfoVOList)) {
            setResponse(response, Result.failure(ResponseCodeEnum.NO_LOGIN));
            return false;
        }
        if(request.getRequestURI().equals(Constants.ADD_USER_URL) && !userInfoVOList.get(0).getPermission().equals(UserRoleEnum.ADMIN.key)) {

            setResponse(response, Result.failure(ResponseCodeEnum.PERMISSION_DENY));
            return false;
        }
        return true;
    }

    private void setResponse(HttpServletResponse response, Result result) {

        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.print(JSON.toJSONString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
