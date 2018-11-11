package com.zhang.myblog.repository;

import com.zhang.myblog.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/11/5
 * @备注 Authority权限仓库
 **/
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
