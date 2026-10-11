package com.atguigu.AOPclass;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLog {

    @Before(value = "execution(* com.atguigu.Demo1..*.*(..))")
    public void beforeMethod(JoinPoint jp){
        String name = jp.getSignature().getName();
        Object[] obj = jp.getArgs();
        System.out.println("log--->> 前置通知 现在执行了beforeMethod方法");
        //System.out.println("方法名是: " + name);
    }

    //后置通知, 在方法运行完之后运行
    @After(value = "execution(* com.atguigu.Demo1..*.*(..))" )
    public void afterMethod(JoinPoint jp){
        String name = jp.getSignature().getName();
        Object[] obj = jp.getArgs();
        System.out.println("log--->> 后置通知执行afterMethod方法");
        //System.out.println("方法名是: " + name);
    }

    @AfterReturning(value = "execution(* com.atguigu.Demo1..*.*(..))" , returning = "aa")
    public void afterReturningMethod(JoinPoint jp , Object aa){
        String name = jp.getSignature().getName();
        Object[] obj = jp.getArgs();
        System.out.println("log--->> 返回参数通知 执行afterReturningMethod方法");
        if(aa == null){
            System.out.println("这个方法没有返回值");
        }else{
            System.out.println(aa.toString());
        }
    }
    @AfterThrowing(value = "execution(* com.atguigu.Demo1..*.*(..))" , throwing = "aa")
    public void afterReturningMethod(JoinPoint jp , Throwable aa){
        String name = jp.getSignature().getName();
        Object[] obj = jp.getArgs();
        System.out.println("log--->> 抛出异常通知  执行afterThrowing方法");
        System.out.println(aa);

    }

    @Around(value = "execution(* com.atguigu.Demo1..*.*(..))")
    public Object aroundMethod(ProceedingJoinPoint jp){
        Object temp = null;
        try{
            System.out.println("  around-log--->> 之前");
            temp = jp.proceed();

            System.out.println("   arouond-log--->> 返回值");

        }catch(Throwable ta){
            System.out.println("  around-log--->> 异常");
            return 0;
        }finally{
            System.out.println("  around-log---> 之后");
        }
        return temp;
    }








}
