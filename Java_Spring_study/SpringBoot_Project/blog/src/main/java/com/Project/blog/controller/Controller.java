package com.Project.blog.controller;

import com.Project.blog.Bean.Po.Article;
import com.Project.blog.Bean.Vo.Article.VoArticle;
import com.Project.blog.Bean.Vo.Article.VoArticleSimple;
import com.Project.blog.Bean.exception.BizException;
import com.Project.blog.Bean.exception.BizExceptionEnum;
import com.Project.blog.iservice.article.ArticleService;
import com.Project.blog.iservice.user.UserService;
import com.Project.blog.iservice.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class Controller {


    @Autowired
    //@Qualifier("us1")
    UserService userService;


    @Autowired
    //@Qualifier("as1")
    ArticleService articleService;


    @GetMapping("hello")
    public String test(){
        return "你好";
    }


    //请求查看所有文章, 但是要求分页
    @GetMapping("articles")
    public List<VoArticleSimple> handle01(@RequestParam("page") int page){
        return articleService.getArticleByPage(page);
    }

    //现在实现点击然后查看单一文章的详细内容
    @GetMapping("article/{id}")
    public VoArticle handle02(@PathVariable("id") Long id){
        return articleService.getArticleById(id);
    }



}
