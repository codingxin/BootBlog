package com.zhang.myblog.service.impl;

import com.zhang.myblog.entity.Authority;
import com.zhang.myblog.repository.AuthorityRepository;
import com.zhang.myblog.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/11/5
 * @备注 服务接口的实现
 **/
@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority getAuthorityById(Long id) {
        return authorityRepository.findOne(id);
    }
}
