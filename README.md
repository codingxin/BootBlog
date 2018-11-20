**慕课网实战课程项目-基于Spring boot博客的搭建教程**
**技术栈**
 * 后端： SpringBoot+ElasticSearch+SpringSecurity

 * 前端： Thymeleaf/Bootstrap/jQuery
 * 数据库：MySQL/MongoDB/H2
 * 技术语言 jdk 1.8
 * 开发平台 Idea 2018 +win10
 ------
项目简介：

[慕课网视频简介](https://coding.imooc.com/class/125.html)
项目源码：

[github仓库源码下载](https://github.com/994683607/BootBlog)

目录如下：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181120195552456.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM1MTgwOTcz,size_16,color_FFFFFF,t_70)

仓库代码

```
|--MyBlog-auth: 加入认证
|--MyBlog-blog: 
|--MyBlog-catalog  加入分类功能
|--MyBlog-comment  加入评论功能
|--MyBlog-prototype  加入
|--MyBlog-search       加入搜索工程
|--MyBlog-tag            加入标签功能
|--MyBlog-user        加入用户功能
|--MyBlog-vote:        加入点赞功能
|--MyBlog-index:        最终项目
elaseticsearch: ES客户端
springbootEs：测试ES的工程项目
博客教学源码：慕课网源码（参考其中的静态资源）
```
注： 整个工程是迭代开发，不是聚合项目。从最开始的基础项目，复制项目再加入新功能如标签，点赞，评论等后重命名

-----
**已经完成的功能：**
1.首页搜索      
2.分类管理
3.用户管理      
4.评论管理
5.角色管理      
6.点赞管理
7.权限管理     
8.标签管理
9.博客管理     

-------
#  运行项目
## 1.[下载源码(https://github.com/994683607/BootBlog)，并解压缩

## 2.导入项目名为Myblog-index项目到idea，导入pom.xml即可，详情如下。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181120200709371.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM1MTgwOTcz,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181120200728967.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM1MTgwOTcz,size_16,color_FFFFFF,t_70)

## 3.本地mysql服务需要开启，在任务管理器中查看mysql服务是否启动。通过数据库可视化工具新建数据库db_testboot(在application.properties配置数据库名)注：
不需要建表，本项目会自动建表，配置在application.properties中。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181120201023662.png)

特别注意需要将上图这个地方改为如下
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181120201119423.png)
这是自动建表配置。
## 4.启动ES服务，在github上下载的压缩包，启动elasticsearch.bat。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181120201219767.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM1MTgwOTcz,size_16,color_FFFFFF,t_70)

## 5.导入文件服务器工程Mongodb-file-server，工程也在git上压缩包。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181120201319813.png)
------
## 6.运行文件服务器和MyBlog-index的springboot启动入口FileApplication.java（8081端口）和
MyBlogApplication.java（8080端口）
## 7.测试：
*输入127.0.0.1:8081测试文件服务器地址。*
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181120201823452.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM1MTgwOTcz,size_16,color_FFFFFF,t_70)
*输入127.0.0.1:8080/index，*
![在这里插入图片描述](https://img-blog.csdnimg.cn/201811202028369.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM1MTgwOTcz,size_16,color_FFFFFF,t_70)

API测试工具：
[swagger简介](https://blog.csdn.net/qq_35180973/article/details/84191759)，
输入地址[http://localhost:8080/swagger-ui.html#!/admin-controller/listUsersUsingGET](http://localhost:8080/swagger-ui.html#!/admin-controller/listUsersUsingGET)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181120203048824.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM1MTgwOTcz,size_16,color_FFFFFF,t_70)


-----

# 慕课网首页预览              
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181120200138673.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM1MTgwOTcz,size_16,color_FFFFFF,t_70)
