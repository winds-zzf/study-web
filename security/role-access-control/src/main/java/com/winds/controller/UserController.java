package com.winds.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 * 角色访问控制
 * 通常情况下，我们需要实现“特定资源只能由特定角色访问”的功能
 */

/**
 * 用户方面的资源
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/hello")
    public String hello(){
        return "user,Hello!";
    }
}
