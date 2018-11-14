package com.zhang.myblog.repository;

import com.zhang.myblog.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @Description TODO  点赞的操作接口
 * @date 2018/11/13
 * @备注
 **/
public interface VoteRepository extends JpaRepository<Vote,Long> {

}
