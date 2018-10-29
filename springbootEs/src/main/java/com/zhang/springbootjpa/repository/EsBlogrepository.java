package com.zhang.springbootjpa.repository;

import com.zhang.springbootjpa.wendang.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/10/26
 * @备注 ESBlog文档接口
 **/
public interface EsBlogrepository extends ElasticsearchRepository<EsBlog, String> {
    //根据方法名 自动匹配功能

    /**
     * 分页查询博客（去重）
     * @param title
     * @param summary
     * @param content
     * @return
     */

    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title,String summary,String content,Pageable pageable);
}
