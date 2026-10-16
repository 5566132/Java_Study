package com.Project.blog.Bean.Vo.User;

import lombok.Data;


//这个就是为了在一些简单场景返回用户的基础信息, 比如查询用户的时候只会返回部分信息,
//比如, 文章中的作者栏也只是用户的简单信息
@Data
public class VoUser {

    //返回给前端的user的id
    private Long id;
    //返回给前端的user的name
    private String name;


}
