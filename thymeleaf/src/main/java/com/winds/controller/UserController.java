package com.winds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.winds.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 必须使用@Controller注解才能实现页面的跳转。因为@RestController返回的是Json数据，而不是一个视图页面
 */
@Controller
public class UserController {
    /**
     * 1. 用户访问http://localhost:8080/users后server端将会调用users函数
     * 2. users函数需要接受Model存储的变量，将渲染demo.html所需要的数据放在model中
     * 3. Thymeleaf渲染demo.html页面并发送给前端
     * 这样用户访问http://localhost:8080/index之后就可以看到一个由thymeleaf模板引擎渲染过的页面demo.html
     */
    @GetMapping("users")
    public String users(Model model){
        List<User> users = new ArrayList<>();
        for (int i=0; i<5; i++) {
            User user = new User();
            user.setId(i);
            user.setName("贝西"+i);
            user.setAddress("山西"+i);
            users.add(user);
        }
        // 将数据以键值对的形式添加到model对象中，在返回页面时传递数据
        model.addAttribute("title","用户地址表");
        model.addAttribute("heads",new String[]{"编号","姓名","地址"});
        model.addAttribute("users",users);
        // 返回demo.html这个页面：Thymeleaf模板的默认位置在classpath:/templates/目录下，默认的后缀是html，这样Thymeleaf就能自动渲染
        return "demo";
    }
}
