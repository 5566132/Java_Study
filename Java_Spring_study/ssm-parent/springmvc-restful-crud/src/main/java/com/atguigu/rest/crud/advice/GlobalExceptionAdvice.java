package com.atguigu.rest.crud.advice;

import com.atguigu.rest.crud.bean.R;
import com.atguigu.rest.crud.exception.BizException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.FileNotFoundException;

@RestControllerAdvice
public class GlobalExceptionAdvice {





    @ExceptionHandler(Exception.class)
    public R handle1(Exception e){
        System.out.println("处理所有异常");
        System.out.println(e.getMessage());


        return R.error(1000, e.getMessage());
    }

    @ExceptionHandler(ArithmeticException.class)
    public R math( ArithmeticException e){

        System.out.println("数学异常");
        return R.error(314, e.getMessage());
    }

    @ExceptionHandler(FileNotFoundException.class)
    public R File_E(FileNotFoundException fe){
        System.out.println("文件io异常");
        return R.error(99999, "执行异常 " + fe.getMessage());
    }


    @ExceptionHandler(BizException.class)
    public R handleExceptionHandler(BizException e){
        System.out.println("自己配置的这个生效了");
        return R.error(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(Throwable.class)
    public R error(Throwable e){
        return R.error(5000, "剩下的所有异常");
    }





}
