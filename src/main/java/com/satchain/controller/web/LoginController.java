package com.satchain.controller.web;

import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.result.Result;
import com.satchain.commons.utils.TokenUtil;
import com.satchain.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
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
 * // TODO: 2019/5/19 dsf
 */
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录验证
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request){

        Assert.notNull(username,"用户名不能为空！");
        Assert.notNull(password,"密码不能为空！");
        String pwd = loginService.getPassword(username);
        if(!password.equals("") && password.equals(pwd)) {

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
