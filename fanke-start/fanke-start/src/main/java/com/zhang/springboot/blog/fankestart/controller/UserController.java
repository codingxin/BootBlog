package com.zhang.springboot.blog.fankestart.controller;

import java.util.List;

import com.zhang.springboot.blog.fankestart.entity.User;
import com.zhang.springboot.blog.fankestart.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/10/23
 * @备注 用户控制层
 **/
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String hello() {
        return "users/list";
    }

    /**
     * 查询所有用户
     *
     * @param model
     * @return
     * @GetMapping是一个组合注解 是@RequestMapping(method = RequestMethod.GET)的缩写
     */
    @GetMapping
    public ModelAndView list(Model model) {
        System.out.println("123");
        model.addAttribute("userList", userRepository.listUser());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }


    /**
     * 根据id来查询用户
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")  //默认 id为字符串String类型
    public ModelAndView finduserByid(@PathVariable("id") Long id, Model model) {
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 创建表单页面
     *
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    @PostMapping
    public ModelAndView saveOrUpdateUser(User user, Model model) {
        user = userRepository.saveOrUpdateUser(user);   //新建的用户，给他赋值id
        return new ModelAndView("users/form", "userModel", model);

    }

}
