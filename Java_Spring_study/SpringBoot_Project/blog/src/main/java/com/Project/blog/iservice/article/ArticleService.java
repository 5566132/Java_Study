package com.Project.blog.iservice.article;

import com.Project.blog.Bean.Po.Article;
import com.Project.blog.Bean.Vo.Article.VoArticle;
import com.Project.blog.Bean.Vo.Article.VoArticleSimple;
import com.baomidou.mybatisplus.spring.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ArticleService extends IService<Article> {


    //分页查询
    public List<VoArticleSimple> getArticleByPage(int page);

    //单id查询文章
    public VoArticle getArticleById(Long id);




}
