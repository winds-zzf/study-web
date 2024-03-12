package com.winds.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IDEA2023中配置热部署
 * 1.勾选 File-Settings-Compiler-Build Project automatically
 * 2.勾选 File-Settings-Advanced Settings-Compiler-Allow auto-make to start even if developed application is currently running
 */

@RestController
public class HelloDemo {
    @RequestMapping("/index")
    public String index(){
        return "index!";
    }

    /**
     * 新增请求处理方法，查看是否热部署成功
     */
    @RequestMapping("/home")
    public String home(){
        return "home!";
    }
}
