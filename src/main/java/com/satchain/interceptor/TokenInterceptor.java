package com.satchain.interceptor;

import com.satchain.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        /*String username = (String) request.getAttribute(Constants.SESSION_USERNAME_KEY);
        List<UserInfoVO> userInfoVOList = userinfoService.queryUserInfo(username);

        if(request.getRequestURI().equals(Constants.ADD_USER_URL) && !userInfoVOList.get(0).getPermission().equals(UserRoleEnum.ADMIN.key)) {

            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.print(JSON.toJSONString(Result.failure(ResponseCodeEnum.PERMISSION_DENY)));
            return false;
        }
        return true;*/
        /*String requestURI = request.getRequestURI();
        if(requestURI.indexOf("/login")<0){
            //说明处在编辑的页面
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute(Constants.SESSION_USERNAME_KEY);
            if(username!=null){
                //登陆成功的用户
                return true;
            }else{
                //没有登陆，转向登陆界面
                //request.getRequestDispatcher("../view/Login.jsp").forward(request,response);
                return false;
            }
        }else{
            return true;
        }*/
        return true;
    }

}
