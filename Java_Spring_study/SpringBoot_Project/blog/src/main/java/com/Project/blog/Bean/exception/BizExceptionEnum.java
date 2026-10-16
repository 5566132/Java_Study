package com.Project.blog.Bean.exception;

import lombok.Getter;

public enum BizExceptionEnum {

    //枚举异常
    NO_THIS_USER(4001, "根本没有这个人");

    @Getter
    private int code;

    @Getter
    private String msg;

    //枚举类是依靠构造方法注入属性的
    BizExceptionEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }




}
