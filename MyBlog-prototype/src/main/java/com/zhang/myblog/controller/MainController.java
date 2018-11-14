package com.zhang.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/10/30
 * @备注 主页控制器
 **/
@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        System.out.println("跳转到主页1");
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        System.out.println("跳转到主页2");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("跳转到主页3");
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登录失败，用户名或者用户错误!");
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

}
