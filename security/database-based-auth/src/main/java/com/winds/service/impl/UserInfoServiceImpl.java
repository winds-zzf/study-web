package com.winds.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.winds.entiry.UserInfo;
import org.winds.mapper.UserMapper;
import org.winds.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfo getUserByUsername(String username){
        return userMapper.getUserByUsername(username);
    }
}
