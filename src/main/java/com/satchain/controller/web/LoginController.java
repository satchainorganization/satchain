package com.satchain.controller.web;

import com.satchain.commons.myEnum.LoginEnum;
import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.result.Result;
import com.satchain.commons.utils.TokenUtil;
import com.satchain.service.LoginService;
import com.satchain.service.LoginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static com.satchain.commons.constants.Constants.SESSION_TOKEN_KEY;
import static com.satchain.commons.constants.Constants.SESSION_USERNAME_KEY;

/**
 * 用户登录
 */
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private LoginfoService loginfoService;
    /**
     * 登录验证
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {

        if (username == "" || username == null || password == "" || password == null) {
            return Result.failure(ResponseCodeEnum.ERROR, "用户名或密码不能为空！");
        }
        String pwd = loginService.getPassword(username);
        if (pwd.equals("nameNotExists")) {
            return Result.failure(ResponseCodeEnum.ERROR, "用户名不存在！");
        }
        if (pwd != null && !pwd.equals(password)) {
            return Result.failure(ResponseCodeEnum.ERROR, "密码错误！");
        } else if (pwd != null && pwd.equals(password)) {
            Map<String, Object> map = new HashMap<String, Object>();
            HttpSession session = request.getSession();
            String token = TokenUtil.genetateToken();
            session.setAttribute(SESSION_TOKEN_KEY, token);
            session.setAttribute(SESSION_USERNAME_KEY, username);
            session.setMaxInactiveInterval(30 * 60);
            map.put("token", token);
            loginfoService.addLoginLog(username,LoginEnum.LOGIN_USER.getKey(),LoginEnum.LOGIN_USER.getValue());
            return Result.success(map);
        }else{
            return Result.failure(ResponseCodeEnum.ERROR,"系统错误，请稍后重试！");
        }
    }

    @RequestMapping("/exit")
    public Result exit(@RequestParam("username") String username,
                       @RequestParam("token") String token, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String sessionToken = (String) session.getAttribute(SESSION_TOKEN_KEY);
        if (token != null && token.equals(sessionToken)) {
            session.removeAttribute(SESSION_USERNAME_KEY);
            session.removeAttribute(SESSION_TOKEN_KEY);
            loginfoService.addLoginLog(username, LoginEnum.EXIT_USER.getKey(), LoginEnum.EXIT_USER.getValue());
        }
        return Result.success();
    }
}
