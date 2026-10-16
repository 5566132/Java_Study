package com.Project.blog.globalAdvice;

import com.Project.blog.Bean.exception.BizException;
import com.Project.blog.Bean.r.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(RuntimeException.class)
    public R handle(BizException e){
        return R.error(e.getCode(), e.getMsg());
    }


    @ExceptionHandler(Throwable.class)
    public R handle(Throwable e){
        return R.error(6666, "碰到剩下的所有异常了");
    }

}
