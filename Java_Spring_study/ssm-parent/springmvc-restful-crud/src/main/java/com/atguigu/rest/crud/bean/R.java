package com.atguigu.rest.crud.bean;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Schema(description = "响应体对象, 描述响应的状态信息")
@Data
public class R<T> {
    @Schema(description = "本次请求的响应体状态码")
    private Integer code;
    @Schema(description = "本次请求的响应体信息")
    private String msg;
    @Schema(description = "本次请求的具体响应内容")
    private T data;
    public static<T> R<T> ok(T ret){

        R<T> r = new R<>();
        r.code = 200;
        r.msg = "正常查询";
        r.data = ret;
        return r;
    }
    public static<T> R<T> ok(){
        R<T> r = new R<>();
        r.code = 200;
        r.msg = "正常查询";
        r.data = null;
        return r;
    }

    public static R error(Integer code, String name){
        R r = new R();
        r.code = code;
        r.msg = name;
        return r;
    }

    public static R error(Integer code , String name , Object o){
        R r = new R();
        r.code = code;
        r.msg = name;
        r.data = o;
        return r;
    }





}
