package com.zhang.springboot.blog.fankestart.repository;

import com.zhang.springboot.blog.fankestart.entity.User;

import java.util.List;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/10/23
 * @备注 测试
 **/
public interface UserRepository {
    /**
     * 创建或者修改用户
     *
     * @param user
     * @return
     */
    public User saveOrUpdateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     */
    public void deleteUser(Long id);

    /**
     * 根据id穿用户
     *
     * @param id
     * @return
     */
    public User getUserById(Long id);

    /**
     * 获取用户列表
     *
     * @return
     */
    public List<User> listUser();


}
