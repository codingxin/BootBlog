package com.waylau.spring.boot.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.waylau.spring.boot.blog.domain.Blog;
import com.waylau.spring.boot.blog.domain.User;
import com.waylau.spring.boot.blog.repository.BlogRepository;

/**
 * Blog 服务.
 * 
 * @since 1.0.0 2017年4月7日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;

	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.blog.service.BlogService#saveBlog(com.waylau.spring.boot.blog.domain.Blog)
	 */
	@Transactional
	@Override
	public Blog saveBlog(Blog blog) {
		return blogRepository.save(blog);
	}

	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.blog.service.BlogService#removeBlog(java.lang.Long)
	 */
	@Transactional
	@Override
	public void removeBlog(Long id) {
		blogRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.blog.service.BlogService#updateBlog(com.waylau.spring.boot.blog.domain.Blog)
	 */
	@Transactional
	@Override
	public Blog updateBlog(Blog blog) {
		return blogRepository.save(blog);
	}

	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.blog.service.BlogService#getBlogById(java.lang.Long)
	 */
	@Override
	public Blog getBlogById(Long id) {
		return blogRepository.findOne(id);
	}

	@Override
	public Page<Blog> listBlogsByTitleLike(User user, String title, Pageable pageable) {
		// 模糊查询
		title = "%" + title + "%";
		Page<Blog> blogs = blogRepository.findByUserAndTitleLikeOrderByCreateTimeDesc(user, title, pageable);
		return blogs;
	}

	@Override
	public Page<Blog> listBlogsByTitleLikeAndSort(User user, String title, Pageable pageable) {
		// 模糊查询
		title = "%" + title + "%";
		Page<Blog> blogs = blogRepository.findByUserAndTitleLike(user, title, pageable);
		return blogs;
	}

	@Override
	public void readingIncrease(Long id) {
		Blog blog = blogRepository.findOne(id);
		blog.setReading(blog.getReading()+1);
		blogRepository.save(blog);
	}
 

}
