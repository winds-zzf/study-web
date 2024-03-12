package com.winds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import com.winds.dao.UserRepository;
import com.winds.domain.User;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * 添加
     */
    @PostMapping()
    public User saveUser(@RequestBody User user){
        return userRepository.save(user);
    }

    /**
     * 删除
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }

    /**
     *
     */
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id,@RequestBody User user){
        user.setId(id);
        return userRepository.saveAndFlush(user);
    }

    /**
     *
     */
    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable int id){
        Optional<User> optional = userRepository.findById(id);
        return optional.orElseGet(User::new);
    }

    /**
     *
     */
    @GetMapping("/list")
    public Page<User> pageQuery(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        return userRepository.findAll(PageRequest.of(pageNum-1,pageSize));
    }

    /**
     * 自定义查询方法
     */
    @PostMapping("/login")
    public User getPerson(String username,String password){
        return userRepository.findByUsernameAndPassword(username,password);
    }
}
