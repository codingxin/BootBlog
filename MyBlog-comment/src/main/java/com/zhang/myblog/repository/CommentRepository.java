package com.zhang.myblog.repository;

import com.zhang.myblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/11/12
 * @备注  评论管理
 **/
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
