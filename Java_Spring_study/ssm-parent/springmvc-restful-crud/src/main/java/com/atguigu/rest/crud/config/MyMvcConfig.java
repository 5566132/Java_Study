package com.atguigu.rest.crud.config;


import com.atguigu.rest.crud.myhandlerinterceptor.MyHandlerInterceptor1;
import com.atguigu.rest.crud.myhandlerinterceptor.MyHandlerInterceptor2;
import com.atguigu.rest.crud.myhandlerinterceptor.MyHandlerInterceptor3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer{

    @Autowired
    MyHandlerInterceptor1 mi1;

    @Autowired
    MyHandlerInterceptor2 mi2;

    @Autowired
    MyHandlerInterceptor3 mi3;


    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //registry.addInterceptor(mi1).addPathPatterns("/**");
        //registry.addInterceptor(mi2).addPathPatterns("/**");
        //registry.addInterceptor(mi3).addPathPatterns("/**");
    }


}
