package com.atguigu.rest.crud.exception;


import lombok.Data;
import lombok.Getter;


public class BizException extends RuntimeException{

    @Getter
    private int code;
    @Getter
    private String msg;

    public BizException(int code , String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException(BizExceptionEnum e){
        this.code = e.getCode();
        this.msg = e.getMsg();
    }


}
