package com.winds.service;

import org.springframework.stereotype.Service;
import org.winds.entiry.UserInfo;


public interface UserInfoService {
    UserInfo getUserByUsername(String username);
}
