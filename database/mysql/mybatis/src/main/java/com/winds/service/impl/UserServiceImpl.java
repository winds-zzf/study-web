package com.winds.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.winds.domain.User;
import com.winds.mapper.UserMapper;
import com.winds.service.UserService;

import java.util.List;

/**
 * 实现类需要添加注解@Service，并指明接口名称，注意这里是接口名称，而不是实现类的名称
 * 参考[https://blog.csdn.net/qq_26030541/article/details/105063357]
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll(){
        return userMapper.findAll();
    }

    @Override
    public int addUser(User user){
        return userMapper.addUser(user);
    }
}
