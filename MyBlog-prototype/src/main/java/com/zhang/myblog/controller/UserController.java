package com.zhang.myblog.controller;

import com.zhang.myblog.entity.User;
import com.zhang.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        model.addAttribute("userList", userRepository.findAll());
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
        User user = userRepository.findById(id).get();
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
        model.addAttribute("user", new User(null, null, null));
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 修改页面
     *
     * @param model
     * @return
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modifyusers(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }


    /**
     * 表单提交保存数据
     *
     * @param user
     * @param model
     * @return
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user, Model model) {
        user = userRepository.save(user);   //最初方法新建的用户，给他赋值id
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        //Modelandview 设置重定向
        return new ModelAndView("redirect:/users");
    }


}
