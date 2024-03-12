package com.winds.domain;


import java.io.Serializable;

/**
 * 缓存到Redis中的实体，需要实现Serializable接口
 */
public class User implements Serializable {
    private int id;
    private String name;
    private String pwd;

    public User() {}

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
