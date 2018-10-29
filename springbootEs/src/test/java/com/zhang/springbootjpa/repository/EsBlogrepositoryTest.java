package com.zhang.springbootjpa.repository;

import com.zhang.springbootjpa.wendang.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/10/26
 * @备注 ESBlog文档接口
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogrepositoryTest {
    @Autowired
    private EsBlogrepository esBlogrepository;

    @Before
    public void initRRepositoryData() {
        //清除所有数据
        esBlogrepository.deleteAll();
        esBlogrepository.save(new EsBlog("等鹳雀楼", "王之涣", "白日依山尽，黄河入海流。欲穷千里目，更上一层楼。"));
        esBlogrepository.save(new EsBlog("相思", "王维相思", "红豆思南国，春来发几枝。愿君多采撷，此物最相思。"));
        esBlogrepository.save(new EsBlog("静夜思", "李白静夜思", "床前明月光，疑是地上霜。举头望明月，低头思故乡"));


    }

    @Test
    public void testfindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
        Pageable pageable = new PageRequest(0, 20);
        String title = "相思";
        String summary = "思";
        String content = "思";
        Page<EsBlog> page = esBlogrepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        assertThat(page.getTotalElements()).isEqualTo(2);
        System.out.println("----------start  1");
        //page.getContent获取数据列表
        for (EsBlog blog : page.getContent()) {
            System.out.println(blog.toString());
        }
        System.out.println("----------end  1");



       title = "相思";
       page = esBlogrepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        assertThat(page.getTotalElements()).isEqualTo(2);
        System.out.println("----------start  2");
        //page.getContent获取数据列表
        for (EsBlog blog : page.getContent()) {
            System.out.println(blog.toString());
        }
        System.out.println("----------end  2");


    }
}
