package com.Project.blog;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.Project.blog.mapper")
@SpringBootApplication
public class BlogApplication {


    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}
