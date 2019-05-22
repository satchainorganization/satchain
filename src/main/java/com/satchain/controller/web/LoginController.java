package com.satchain.controller.web;

import com.satchain.bean.model.Loginfo;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.satchain.commons.constants.Constants.SESSION_TOKEN_KEY;
import static com.satchain.commons.constants.Constants.SESSION_USERNAME_KEY;

/**
 * 用户登录
 * bingo
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
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request){


        String pwd = loginService.getPassword(username);

        // 帐号密码正确
        if(password != null && password.equals(pwd)) {

            // 添加登录日志
            Loginfo loginfo = new Loginfo();
            loginfo.setEventType((byte) 1);
            loginfo.setObjects(username);
            loginfo.setTime(new Date());
            loginfoService.insertLogInfo(loginfo);

            Map<String,Object> map = new HashMap<String, Object>();
            HttpSession session = request.getSession();
            String token = TokenUtil.genetateToken();
            session.setAttribute(SESSION_TOKEN_KEY,token);
            session.setAttribute(SESSION_USERNAME_KEY, username);
            session.setMaxInactiveInterval(30 * 60);
            map.put("token", token);
            return Result.success(map);
        }

        return Result.failure(ResponseCodeEnum.ERROR);
    }

    @RequestMapping("/exit")
    public Result exit(@RequestParam("username") String username,
                       @RequestParam("token") String token, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String sessionToken = (String) session.getAttribute(SESSION_TOKEN_KEY);
        if(token != null && token.equals(sessionToken)) {

            session.removeAttribute(SESSION_TOKEN_KEY);
        }

        return Result.success();
    }
}
