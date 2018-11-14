package com.zhang.myblog.service.impl;

import com.zhang.myblog.entity.Comment;
import com.zhang.myblog.repository.CommentRepository;
import com.zhang.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/11/12
 * @备注 测试
 **/
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findOne(id);
    }

    @Override
    public void removeComment(Long id) {
        commentRepository.delete(id);
    }
}
