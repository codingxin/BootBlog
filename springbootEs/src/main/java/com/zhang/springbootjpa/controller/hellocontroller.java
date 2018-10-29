package com.zhang.springbootjpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/10/22
 * @备注 测试
 **/
@RestController
public class hellocontroller {
    @RequestMapping("/hello")
    public String hello(){
        return "hello worl2d!";
    }


}
