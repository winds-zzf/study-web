package com.winds.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @PostMapping("/hello")
    public String hello(@RequestBody String message){
        System.out.println("Receive:"+message);
        return "Hello Browser";
    }
}
