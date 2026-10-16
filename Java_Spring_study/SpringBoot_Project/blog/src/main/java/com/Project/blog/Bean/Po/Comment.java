package com.Project.blog.Bean.Po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_comment")
public class Comment {

    //评论的id
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    //评论的内容
    @TableField("context")
    private String context;


    //评论属于哪个作者
    @TableField("user_id")
    private Long userId;


    //评论属于哪个文章
    @TableField("article_id")
    private Long articleId;




}
