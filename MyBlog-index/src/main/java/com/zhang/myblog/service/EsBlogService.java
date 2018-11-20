package com.zhang.myblog.service;


import com.zhang.myblog.entity.User;
import com.zhang.myblog.entity.es.EsBlog;
import com.zhang.myblog.util.TagVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * ESBlog 服务接口.
 */
public interface EsBlogService {

    /**
     * 删除Blog
     *
     * @param id
     * @return
     */
    void removeEsBlog(String id);

    /**
     * 更新 EsBlog
     *
     * @param
     * @return
     */
    EsBlog updateEsBlog(EsBlog esBlog);

    /**
     * 根据id获取Blog
     *
     * @param blogId
     * @return
     */
    EsBlog getEsBlogByBlogId(Long blogId);

    /**
     * 最新博客列表，分页
     *
     * @param keyword
     * @param pageable
     * @return
     */
    Page<EsBlog> listNewestEsBlogs(String keyword, Pageable pageable);

    /**
     * 最热博客列表，分页
     *
     * @param keyword
     * @param pageable
     * @return
     */
    Page<EsBlog> listHotestEsBlogs(String keyword, Pageable pageable);

    /**
     * 博客列表，分页
     *
     * @param pageable
     * @return
     */
    Page<EsBlog> listEsBlogs(Pageable pageable);

    /**
     * 最新前5
     *
     * @param
     * @return
     */
    List<EsBlog> listTop5NewestEsBlogs();

    /**
     * 最热前5
     *
     * @param
     * @return
     */
    List<EsBlog> listTop5HotestEsBlogs();

    /*	*
     * 最热前 30 标签
     * @return*/
    List<TagVO> listTop30Tags();

    /**
     * 最热前12用户
     *
     * @return
     */
    List<User> listTop12Users();
}
