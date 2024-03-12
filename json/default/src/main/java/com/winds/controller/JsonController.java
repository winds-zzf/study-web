package com.winds.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.winds.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/json")
public class JsonController {
    // 返回User对象的json字符串
    @RequestMapping("/user")
    public User getUser(){
        return new User(1,"贝西","123456");
    }

    // 返回List对象的json字符串
    @RequestMapping("/list")
    public List<User> getUserList(){
        List<User> users = new ArrayList<>();
        User user1 = new User(1,"贝西","123456");
        User user2 = new User(2,"贾志杰","123456");
        users.add(user1);
        users.add(user2);
        return users;
    }

    // 返回Map对象的json字符串
    @RequestMapping("/map")
    public Map<String,Object> getMap(){
        Map<String,Object> map = new HashMap<>(3);
        User user = new User(1,"贾志杰","123456");
        map.put("作者信息",user);
        map.put("博客地址","https://blog.csdn.net/beixishuo");
        map.put("公众号","贝西奇谈");
        map.put("B站","贝西奇谈");
        return map;
    }
}
