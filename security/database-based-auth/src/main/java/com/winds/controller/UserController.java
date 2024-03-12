package com.winds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.winds.entiry.UserInfo;
import org.winds.service.UserInfoService;

@RestController
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/getUser")
    public UserInfo getUser(@RequestParam String username){
        return userInfoService.getUserByUsername(username);
    }
}
