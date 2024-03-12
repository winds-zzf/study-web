package com.winds.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员方面的资源
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/hello")
    public String hello(){
        return "admin,Hello!";
    }
}
