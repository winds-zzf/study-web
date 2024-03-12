package com.winds.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 通过Lombok提供的注解消除setter和getter等代码
 */
@Data
@AllArgsConstructor
public class UserInfo implements Serializable, UserDetails {
    private int id;
    private String username;
    private String password;
    private String role;


    /**
     * 获取当前用户对象密码
     * @return 用户对象密码
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * 获取当前用户对象用户名
     * @return 当前用户对象用户名
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * 《获取用户的角色集，默认需要添加ROLE_前缀》
     * 得到用户的权限，如果权限表和用户表是分开的，我们需要再重新定义一个实体类实现UserDetails并且继承于User类。
     * @return 交给security的权限，放在UserDetailService进行处理
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        /* 角色必须以ROLE_开头,如果数据库没有，则需要加上 */
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.role));
        return authorities;
    }

    /**
     * 《账户是否过期》
     * 指示用户的账户是否已过期。无法验证过期的账户。
     * @return 如果用户的账户有效(即未过期)，则返回true，如果不再有效就返回false
     */
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    /**
     * 《账户是否锁定》
     * 指示用户是锁定还是解锁。无法对锁定的用户进行身份验证。
     * @return 如果用户未被锁定，则返回true，否则返回false
     */
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    /**
     * 《凭证是否过期》
     * 指示用户的凭证(密码)是否已过期。过期的凭证阻止身份验证。
     * @return 如果用户的凭证有效(即未过期)，则返回true；如果不再有效(即过期)，则返回false
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    /**
     * 《用户是否可用》
     * 指示用户是启用还是禁用。无法对禁用的用户进行身份验证。
     * @return 如果启用了用户，则返回true，否则返回false
     */
    @Override
    public boolean isEnabled() {
        return false;
    }
}
