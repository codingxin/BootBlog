package com.zhang.myblog.service;

import com.zhang.myblog.entity.Vote;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @Description TODO
 * @date 2018/11/13
 * @备注
 **/
public interface VoteService {
    /**
     * 根据id获取Vote
     * @param id
     * @return
     */
    Vote getVoteById(Long id);

    /**
     * 根据id删除Vote
     * @param id
     */
    void removeVote(Long id);


}
