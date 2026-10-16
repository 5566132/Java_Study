package com.Project.blog.mapper;

import com.Project.blog.Bean.Po.Article;
import com.Project.blog.Bean.Vo.Article.VoArticle;
import com.Project.blog.Bean.Vo.Article.VoArticleSimple;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    //写个条件构造器查询, 可以应对更多情况
    public List<VoArticle> selectVoArticlesByWrapper(LambdaQueryWrapper<VoArticle> lqw);


    //分页查询吧, 我还不会用那个分页的东西呢
    public List<VoArticleSimple> selectByPage(int offset, int size);

    //我写个比较正规的按照文章的user_id字段查询文章, 然后返回文章的简单视图
    //但是返回要分页
    public List<VoArticleSimple> selectVoArticleSimpleBy_UserId_Page(@Param("userId") Long userId, @Param("offset") int offset, @Param("size") int size);

}
