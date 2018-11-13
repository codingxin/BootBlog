package com.zhang.myblog.service;

import com.zhang.myblog.entity.Comment;

/**  CommentService接口实现
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/11/12
 * @备注 测试
 **/
public interface CommentService {
    /**
     * 根据id获取Comment
     * @param id
     */
   Comment getCommentById(Long id);

    /**
     * 删除评论
     * @param id
     */
   void removeComment(Long id);


}
