package com.Project.blog.mapper;

import com.Project.blog.Bean.Po.Article;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    //写个条件构造器查询, 可以应对更多情况
    public List<Article> selectByWrapper(LambdaQueryWrapper<Article> lqw);

    //分页查询吧, 我还不会用那个分页的东西呢
    public List<Article> selectByPage(int page);

    //


}
