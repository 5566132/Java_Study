package com.Project.blog.Bean.r;


import lombok.Data;

@Data
public class R<T> {
    private int code;
    private String msg;
    private T data;

    public static R ok(){
        R r = new R();
        r.code = 200;
        r.msg = "正常返回";
        r.data = null;
        return r;
    }

    public static<T> R<T> ok(T da){
        R<T> r = new R<>();
        r.code = 200;
        r.msg = "正常返回数据";
        r.data = da;
        return r;
    }

    public static R error(int code, String msg){
        R r = new R();
        r.code = code;
        r.msg = msg;
        return r;
    }


}
