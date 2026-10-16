package com.Project.blog.Bean.exception;

import lombok.Getter;

public class BizException extends RuntimeException {

    @Getter
    private int code;

    @Getter
    private String msg;

    public BizException(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public BizException(BizExceptionEnum e){
        this.code = e.getCode();
        this.msg = e.getMsg();
    }




}
