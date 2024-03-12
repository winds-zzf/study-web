package com.winds.domain;

import jakarta.persistence.*;

@Entity     // 表示该类为实体类
@Table(name="t_user")   // 声明该类映射到数据库的表
public class User {
    @Id     // 代表主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 主键自增的策略
    private Integer id;

    @Column(name="username",unique = true,nullable = false,length = 64)
    private String username;

    @Column(name="password",nullable = false,length = 64)
    private String password;

    @Column(name="email",length = 64)
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
