package com.zhang.myblog.repository;

import com.zhang.myblog.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/10/23
 * @备注 继承CrudRepository，有各种实现
 **/
//public interface UserRepository extends CrudRepository<User, Long> {
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据用户姓名分页查询用户列表
     * @param name
     * @param pageable
     * @return
     */
    Page<User> findByNameLike(String name, Pageable pageable);

    /**
     * 根据用户账号查询用户
     * @param username
     * @return
     */
    User findByUsername(String username);


    /**
     * 创建或者修改用户
     *
     * @param user
     * @return
     */
    /* public User saveOrUpdateUser(User user);

     *//**
     * 删除用户
     *
     * @param id
     *//*
    public void deleteUser(Long id);

    *//**
     * 根据id穿用户
     *
     * @param id
     * @return
     *//*
    public User getUserById(Long id);

    *//**
     * 获取用户列表
     *
     * @return
     *//*
    public List<User> listUser();
*/

}
