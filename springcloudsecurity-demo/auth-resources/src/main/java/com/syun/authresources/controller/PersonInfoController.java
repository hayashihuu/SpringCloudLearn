package com.syun.authresources.controller;

import com.syun.authresources.model.Person;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @program: springcloudsecurity-demo
 * @author: syun
 * @create: 2018-11-24 16:37
 */
@RestController
public class PersonInfoController {


    @GetMapping("/person")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public @ResponseBody
    Person personInfo() {
        return new Person("abir", "Dhaka", "Bangladesh", 29, "Male");
    }
}
