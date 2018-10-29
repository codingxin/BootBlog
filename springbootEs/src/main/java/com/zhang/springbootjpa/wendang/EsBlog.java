package com.zhang.springbootjpa.wendang;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/10/26
 * @备注 ESBlog文档
 **/
//索引，类型
@Document(indexName = "blog", type = "blog")
public class EsBlog implements Serializable {
    @Id  //主键
    private String id;
    //标题
    private String title;
    //摘要
    private String summary;
    //正文
    private String content;

    protected EsBlog() {// Jpa规范要求，防止直接使用

    }

    public EsBlog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
       /* return "EsBlog{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                '}';*/
        return String.format("ESBlog[id='%s',title='%s',summary='%s',content='%s']", id, title, summary, content);


    }
}
