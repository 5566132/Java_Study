package com.atguigu.rest.crud.exception;

import lombok.Getter;

public enum BizExceptionEnum {


    //订单异常
    ORDER_1(1000, "1号异常"),

    ORDER_2(1001, "2号异常"),

    ORDER_3(1002, "3号异常");


    @Getter
    private int code;

    @Getter
    private String msg;

    BizExceptionEnum(int code , String msg){
        this.code = code;
        this.msg = msg;
    }


}
