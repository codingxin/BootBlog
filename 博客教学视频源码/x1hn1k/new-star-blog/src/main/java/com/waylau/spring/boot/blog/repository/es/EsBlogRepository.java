package com.waylau.spring.boot.blog.repository.es;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.waylau.spring.boot.blog.domain.es.EsBlog;

/**
 * Blog 存储库.
 * 
 * @since 1.0.0 2017年3月12日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {
 
	/**
	 * 模糊查询(去重)
	 * @param title
	 * @param Summary
	 * @param content
	 * @param tags
	 * @param pageable
	 * @return
	 */
	Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContainingOrTagsContaining(String title,String Summary,String content,String tags,Pageable pageable);
	
	EsBlog findByBlogId(Long blogId);
}
