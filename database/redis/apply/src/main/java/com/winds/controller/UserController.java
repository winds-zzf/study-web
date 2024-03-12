package com.winds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.winds.domain.User;
import com.winds.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/queryAll")
    public List<User> queryAll(){
        return userService.queryAll();
    }

    @RequestMapping("/findUserById")
    public Map<String,Object> findUserById(@RequestParam int id){
        User user = userService.findUserById(id);
        Map<String,Object> result = new HashMap<>();
        result.put("id",user.getId());
        result.put("name",user.getName());
        result.put("pwd",user.getPwd());
        return result;
    }
}
