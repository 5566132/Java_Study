package com.Project.blog.Bean.Po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("tb_article")
public class Article {


    //文章id
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //文章名
    @TableField(value = "name")
    private String name;


    //文章的内容
    @TableField("context")
    private String context;


    //文章的持有者(User)的id
    @TableField("user_id")
    private Long userId;





/*
    //本篇文章的所有评论
    private List<Comment> comments;
*/


}
