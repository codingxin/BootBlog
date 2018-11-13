package com.zhang.myblog.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/11/5
 * @备注 权限
 **/
@Entity
public class Authority implements GrantedAuthority {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增长策略
    private long id;

    @Column(nullable = false)
    private String name;

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
