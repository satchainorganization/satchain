package com.satchain.controller.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 董少飞
 * @date 2019/5/18
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {

        return "asdf";
    }
}
