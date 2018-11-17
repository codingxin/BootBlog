package com.zhang.myblog.repository;

import com.zhang.myblog.entity.Catalog;
import com.zhang.myblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @Description TODO  分类管理接口
 * @date 2018/11/13
 * @备注
 **/
public interface CatalogRepository extends JpaRepository<Catalog,Long> {
    /**
     * 根据用户查询
     * @param user
     * @return
     */
    List<Catalog> findByUser(User user);

    /**
     * 根据用户和分类名字查询
     * @param user
     * @param name
     * @return
     */
    List<Catalog> findByUserAndName(User user,String name);

}
