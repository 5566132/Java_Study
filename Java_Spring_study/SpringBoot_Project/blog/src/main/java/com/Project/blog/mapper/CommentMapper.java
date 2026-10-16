package com.Project.blog.mapper;

import com.Project.blog.Bean.Po.Comment;
import com.Project.blog.Bean.Vo.Comment.VoComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    //根据article_id查询一堆comment
    public List<VoComment> selectCommentByArticleId(Long id);

}
