package com.atguigu.springmvc.Config;

import com.atguigu.springmvc.responseindex.Per;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean("p1")
    public Per getPer(){
        Per temp = new Per();
        temp.setUsername("你好, 测试json");
        temp.setPassword("123666");
        temp.setCellphone("123-0609");
        temp.setAgreement("true");
        return temp;
    }
}
