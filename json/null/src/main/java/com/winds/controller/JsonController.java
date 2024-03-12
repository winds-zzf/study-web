package com.winds.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.winds.domain.User;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/json")
public class JsonController {
    // 测试null的处理
    @RequestMapping("/null")
    public Map<String,Object> getNull(){
        Map<String,Object> map = new HashMap<>(3);
        User user = new User(1,"贾志杰",null);
        map.put("作者信息",user);
        map.put("博客地址","https://blog.csdn.net/beixishuo");
        map.put("公众号","贝西奇谈");
        map.put("B站",null);
        return map;
    }
}
