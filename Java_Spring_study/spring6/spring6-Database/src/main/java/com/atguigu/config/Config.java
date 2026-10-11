package com.atguigu.config;

import com.atguigu.jdbc.F1;
import com.atguigu.jdbc.F2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.atguigu")
public class Config {
    @Bean("f1")
    public F1 getF1(){
        return new F1();
    }

    @Bean("f2")
    public F2 getF2(@Qualifier("f1") F1 f){
        F2 ret = new F2();
        ret.f = f;
        return ret;
    }


}
