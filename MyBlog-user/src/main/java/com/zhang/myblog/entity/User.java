package com.zhang.myblog.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/10/23
 * @备注 用户实体
 **/
@Entity
public class User {
    @Id  //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//生成策略
    private Long id;  //实体唯一标识

    @NotEmpty(message = "姓名不能为空")
    @Size(min = 2, max = 20)
    @Column(nullable = false, length = 20)
    private String name;

    @NotEmpty(message = "邮箱不能为空")
    @Size(max = 50)
    @Email(message = "邮箱格式")
    @Column(nullable = false, length = 20, unique = true)
    private String email;

    @NotEmpty(message = "帐号不能为空")
    @Size(min = 3, max = 50)
    @Column(nullable = false, length = 20, unique = true)
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Size(max = 100)
    @Column(length = 100)
    private String password;
    @Column(length = 200)
    private String avator;

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

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    protected User() {
        //设为protected ，防止直接使用
    }

    public User(Long id, String name, String email, String username) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
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

    @Override
    public String toString() {
        return String.format("User[id=%d,name='%s',email='%s',username='%s']", id, name, email, username);
    }
}
