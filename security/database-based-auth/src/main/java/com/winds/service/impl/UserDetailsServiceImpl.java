package com.winds.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.winds.entiry.UserInfo;
import org.winds.service.UserInfoService;

import java.util.ArrayList;
import java.util.List;

/**
 * 要从数据库读取用户信息进行身份认证，需要新建类实现UserDetailsService接口并重写loadUserByUsername方法
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserInfoService userInfoService;

    /*
     * 需新建配置类注册一个指定的加密方式Bean，或者在下一步Security配置类中注册指定
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /*
     * 该方法将在用户登陆时自动调用
     * username是登陆时的用户名，通过该用户名去数据库查找用户，如果查到了用户，就会将用户及角色信息返回，如果不存在就抛出用户不存在异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 通过用户名从数据库获取用户信息
        UserInfo userInfo = userInfoService.getUserByUsername(username);
        if(userInfo==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        // 得到用户界色
        String role = userInfo.getRole();
        // 角色集合
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 角色必须以'ROLE_'开头，如果数据库中没有，则在这里添加
        authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
        return new User(
                userInfo.getUsername(),
                /* 因为数据库是明文，所以这里需要加密密码 */
                passwordEncoder.encode(userInfo.getPassword()),
                authorities
        );
    }
}
