package com.satchain.controller.web;

import com.satchain.bean.vo.UserChangeVO;
import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.result.Result;
import com.satchain.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * 用户内容表：增删改查
 */
@RestController
public class UserinfoController {
    @Autowired
    private UserinfoService userinfoService;
    /**
     * 3.19增加用户
     */
    @RequestMapping(value = "/addUsers", method = RequestMethod.POST)
    public Result addusers(@RequestParam("username") String username, @RequestParam("password") String password,
                           @RequestParam("permission") Integer permission) throws Exception {

        //todo 管理员权限
        Assert.notNull(username,"参数错误！");
        Assert.notNull(password,"参数错误！");
        Assert.notNull(permission,"参数错误！");

        int n = userinfoService.insertUser(username,password,permission);
        if (n == 0){
            return Result.failure(ResponseCodeEnum.ERROR,"增加用户失败");
        }
        return Result.success();
    }

    /**
     * 3.20用户信息查询
     */
    @RequestMapping(value = "/queryUsers", method = RequestMethod.POST)
    public Result queryUsers(@RequestParam("username") String username){
        return Result.success(userinfoService.queryUserInfo(username));
    }

    /**
     * 21 编辑用户信息
     */
    @RequestMapping(value = "/editUsers", method = RequestMethod.POST)
    public Result editUsers(@RequestParam("username") String username, @RequestParam("password") String password,
                            @RequestParam("permission") Integer permission) throws ParseException {

        Assert.notNull(username,"参数错误！");
        Assert.notNull(password,"参数错误！");
        Assert.notNull(permission,"参数错误！");

        UserChangeVO userChangeVO = userinfoService.updateUserInfo(username,password,permission);
        if (userChangeVO == null){
            return Result.failure(ResponseCodeEnum.ERROR,"修改用户失败");
        }
        return Result.success(userChangeVO);
    }
    /**
     * 3.22用户信息删除
     */
    @RequestMapping(value = "/deleteUsers", method = RequestMethod.DELETE)
    public Result deleteUsers(@RequestParam("username") String username){
        Assert.notNull(username,"参数错误！");
        int n = userinfoService.deleteUserInfo(username);
        if (n == 0){
            return Result.failure(ResponseCodeEnum.ERROR,"删除用户失败");
        }
        return Result.success();
    }
}
