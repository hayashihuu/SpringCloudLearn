package com.syun.oauth2server.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description: 登录跳转
 * @program: springcloud-kiroku
 * @author: syun
 * @create: 2018-11-19 13:50
 */
@RestController
public class AuthController {


    @GetMapping("/test/test")
    public String test(){
        return "testtest";
    }

    @GetMapping("/login")
    public ModelAndView require() {
        return new ModelAndView("login");
    }

    @GetMapping("/oauth/confirm_access")
    public ModelAndView auth(){
        return new ModelAndView("authorize");
    }


}
