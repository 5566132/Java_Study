package com.Project.blog.iservice.comment;

import com.Project.blog.Bean.Po.Comment;
import com.Project.blog.Bean.Vo.Comment.VoComment;
import com.Project.blog.mapper.CommentMapper;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    //根据article_id查询一堆comment
    public List<VoComment> getCommentByArticleId(Long id){
        return commentMapper.selectCommentByArticleId(id);
    }

    //根据article_id查询一堆comment
    public List<VoComment> getCommentsByArticleId(Long articlesId){
        return commentMapper.selectCommentsByArticleId(articlesId);
    }

}
