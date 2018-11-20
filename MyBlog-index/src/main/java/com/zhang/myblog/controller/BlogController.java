package com.zhang.myblog.controller;

import com.zhang.myblog.entity.User;
import com.zhang.myblog.entity.es.EsBlog;
import com.zhang.myblog.service.EsBlogService;
import com.zhang.myblog.util.TagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/10/30
 * @备注 Blog控制器
 **/
@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private EsBlogService esBlogService;

    /**
     * @param order   排序规则
     * @param keyword 关键字
     * @return
     */
    @GetMapping
    public String listBlogs(@RequestParam(value = "order", required = false, defaultValue = "new") String order,       @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,        @RequestParam(value = "async", required = false)  boolean async,                             @RequestParam(value = "pageIndex", required = false, defaultValue = "0")  int pageIndex,     @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,Model model)
    {
      Page<EsBlog> page=null;
      List<EsBlog> list=null;
      boolean isEmpty=true;  //系统初始化时，没有博客数据
        try {
            if(order.equals("hot")){
                Sort sort=new Sort(Sort.Direction.DESC,"readSize","commentSize","voteSize","createTime");
                Pageable pageable=new PageRequest(pageIndex,pageSize,sort);
                page=esBlogService.listHotestEsBlogs(keyword,pageable);
            }
            else if(order.equals("new")){
                Sort sort=new Sort(Sort.Direction.DESC,"createTime");
                Pageable pageable=new PageRequest(pageIndex,pageSize,sort);
                page=esBlogService.listNewestEsBlogs(keyword,pageable);
            }
            isEmpty=false;
        }catch (Exception e){
            Pageable pageable=new PageRequest(pageIndex,pageSize);
            page=esBlogService.listEsBlogs(pageable);
        }

        list = page.getContent();	// 当前所在页面数据列表
        model.addAttribute("order", order);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("blogList", list);

        // 首次访问页面才加载  以下信息都在主页右侧，只需要刷新一次就行。
        if (!async && !isEmpty) {
            List<EsBlog> newest = esBlogService.listTop5NewestEsBlogs();
            model.addAttribute("newest", newest);
            List<EsBlog> hotest = esBlogService.listTop5HotestEsBlogs();
            model.addAttribute("hotest", hotest);
            List<TagVO> tags = esBlogService.listTop30Tags();
            model.addAttribute("tags", tags);
            List<User> users = esBlogService.listTop12Users();
            model.addAttribute("users", users);
        }

        return (async==true?"index :: #mainContainerRepleace":"index");

    }
    @GetMapping("/newest")
    public String listNewestEsBlogs(Model model) {
        List<EsBlog> newest = esBlogService.listTop5NewestEsBlogs();
        model.addAttribute("newest", newest);
        return "newest";
    }

    @GetMapping("/hotest")
    public String listHotestEsBlogs(Model model) {
        List<EsBlog> hotest = esBlogService.listTop5HotestEsBlogs();
        model.addAttribute("hotest", hotest);
        return "hotest";
    }

}
