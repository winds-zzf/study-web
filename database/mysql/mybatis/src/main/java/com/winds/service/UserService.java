package com.winds.service;


/**
 * 为什幺service层要添加接口？
 */

import com.winds.domain.User;

import java.util.List;

/**
 * XXXService.java接口不添加@Service注解，该注解添加在XXXServiceImpl上，因为实现类才能产生一个实例
 */
public interface UserService {
    List<User> findAll();

    int addUser(User user);
}
