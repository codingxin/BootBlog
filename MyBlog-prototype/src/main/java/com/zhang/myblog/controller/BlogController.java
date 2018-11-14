package com.zhang.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/10/30
 * @备注 Blog控制器
 **/
@Controller
@RequestMapping("/blogs")
public class BlogController {
    /**
     * @param order   排序规则
     * @param keyword 关键字
     * @return
     */
    @GetMapping
    public String listBlogs(@RequestParam(value = "order", required = false, defaultValue = "new") String order, @RequestParam(value = "keyword", required = false,defaultValue = "") String keyword) {
        System.out.println("order:" + order + ",keyword:" + keyword);
        return "redirect:/index?order=" + order + "&keyword=" + keyword;
    }


}
