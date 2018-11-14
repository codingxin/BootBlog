package com.zhang.myblog.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/10/30
 * @备注 安全配置类
 **/

/**
 * SpringBoot2.0抛弃了原来的NoOpPasswordEncoder，要求用户保存的密码必须要使用加密算法后存储，在登录验证的时候Security会将获得的密码在进行编码后再和数据库中加密后的密码进行对比
 */
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll()  //可以访问的文件目录
                .antMatchers("/users/**").hasRole("Admin")//需要相应角色users才能访问
                .and().formLogin()  //基于Form表单登陆验证
                .loginPage("/login").failureUrl("/login-error")
                .and().logout().permitAll(); //自定义登录界面
        http.csrf().disable();

    }

    /**
     * @param auth
     * @throws Exception
     */

    @Autowired
    public void ConfigureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //可以设置内存指定的登录的账号密码,指定角色
        //不加.passwordEncoder(new MyPasswordEncoder())
        //就不是以明文的方式进行匹配，会报错
       /* auth.inMemoryAuthentication().//认证信息存储在内存中
                withUser("admin").password("admin").roles("HElLO");*/
        //.passwordEncoder(new MyPasswordEncoder())。
        //这样，页面提交时候，密码以明文的方式进行匹配。
        //inMemoryAuthentication在内存中初始化认证的用户信息
        auth.inMemoryAuthentication().withUser("root").password("root").roles("Admin").and().passwordEncoder(new MyPasswordEncoder())
        ;
    }


}
