package com.zhang.springbootjpa.controller;

import com.zhang.springbootjpa.repository.EsBlogrepository;
import com.zhang.springbootjpa.wendang.EsBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/10/29
 * @备注 测试
 **/
@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private EsBlogrepository esBlogrepository;

    @GetMapping
    public List<EsBlog> list(@RequestParam(value = "title") String title, @RequestParam(value = "summary") String summary, @RequestParam(value = "content") String content, @RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<EsBlog> page = esBlogrepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        return page.getContent();

    }


}
