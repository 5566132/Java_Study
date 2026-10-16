package com.Project.blog.Bean.Po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("tb_user")
public class User {


    //用户id
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    //用户姓名
    @TableField("name")
    private String name;


    //用户密码
    @TableField("password")
    private String password;



/*
    //用户的所有文章
    private List<Article> articles;
    //用户的所有评论
    private List<Comment> comments;
*/

}
