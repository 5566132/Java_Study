package com.atguigu.rest.crud.myhandlerinterceptor;

import com.atguigu.rest.crud.Controller.EmployeeRestController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;

@Component
public class MyHandlerInterceptor1 implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        StringBuffer URL = request.getRequestURL();
//        System.out.println("请求的URL = " + URL.toString());
//        if(handler instanceof HandlerMethod){
//            EmployeeRestController controller = (EmployeeRestController) ((HandlerMethod) handler).getBean();
//            Method m = ((HandlerMethod) handler).getMethod();
//            controller.test();
//            if(m.getName().equals("get")){
//                System.out.println("这个方法是查询单个员工的方法");
//            }
//        }
        System.out.println("preInterceptor11111");
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("postInterceptor111111111111");
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
        System.out.println("afterInterceptor1111111111111");
    }



}
