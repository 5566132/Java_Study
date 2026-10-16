package com.Project.blog.iservice.comment;

import com.Project.blog.Bean.Po.Comment;
import com.Project.blog.Bean.Vo.Comment.VoComment;
import com.baomidou.mybatisplus.spring.service.IService;

import java.util.List;

public interface CommentService extends IService<Comment> {

    //根据article_id查询一堆comment
    public List<VoComment> getCommentByArticleId(Long id);

    //根据article_id查询一堆comment
    public List<VoComment> getCommentsByArticleId(Long articlesId);

}
