package com.Project.blog.iservice.article;

import com.Project.blog.Bean.Po.Article;
import com.Project.blog.Bean.Vo.Article.VoArticle;
import com.Project.blog.Bean.Vo.Article.VoArticleSimple;
import com.Project.blog.Bean.pageResult.PageRequest;
import com.baomidou.mybatisplus.spring.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ArticleService extends IService<Article> {


/*    //分页查询
    public List<VoArticleSimple> getVoArticlesByPage(int page);
    */

    //重写的分页查询文章
    public PageRequest<List<VoArticleSimple>> getVoArticles(int page, int size);

    //单文章id查询文章
    public VoArticle getArticleById(Long id);

    //user_id查询文章, 返回文章的简单视图, 再加个分页返回
    public PageRequest<List<VoArticleSimple>> getVoArticleSimple_ByUserId_Page(Long userId, int page, int size);





}
