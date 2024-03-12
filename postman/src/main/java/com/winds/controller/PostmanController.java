package com.winds.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostmanController {
    @PostMapping("/login")
    public String login(String username,String password){
        return "操作成功!";
    }
}
