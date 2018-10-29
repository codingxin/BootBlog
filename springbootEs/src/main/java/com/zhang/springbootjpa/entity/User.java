package com.zhang.springbootjpa.entity;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/10/23
 * @备注 用户实体
 **/
public class User {
     Long id;  //实体唯一标识
     String name;
     String email;
    public User(){

    }
    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
