package com.atguigu.mybatis.config;


import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.atguigu.mybatis")
public class MybatisConfig {
    @Bean
    PageInterceptor pageInterceptor(){
        PageInterceptor interceptor = new PageInterceptor();
        return interceptor;
    }
}
