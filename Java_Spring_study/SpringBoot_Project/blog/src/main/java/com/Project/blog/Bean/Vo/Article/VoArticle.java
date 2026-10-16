package com.Project.blog.Bean.Vo.Article;


import com.Project.blog.Bean.Po.Article;
import com.Project.blog.Bean.Po.Comment;
import com.Project.blog.Bean.Po.User;
import com.Project.blog.Bean.Vo.Comment.VoComment;
import com.Project.blog.Bean.Vo.User.VoUser;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data
public class VoArticle {

    //文章id
    private Long id;

    //文章名
    private String name;

    //文章的内容
    private String context;


    //直接保留作者的简单信息
    private VoUser vouser;


    //所有评论
    private List<VoComment> comments;


    public void setAll(Article a, VoUser v, List<VoComment> c){
        id = a.getId();
        name = a.getName();
        context = a.getContext();
        vouser = v;
        comments = c;
    }
    public void setBase(Article a){
        id = a.getId();
        name = a.getName();
        context = a.getContext();
    }


}
