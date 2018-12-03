package com.syun.authresources.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @description:
 * @program: springcloudsecurity-demo
 * @author: syun
 * @create: 2018-11-24 16:38
 */
@RestController
public class ResourceController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
