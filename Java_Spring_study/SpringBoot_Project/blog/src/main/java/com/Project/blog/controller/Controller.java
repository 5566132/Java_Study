package com.Project.blog.controller;

import com.Project.blog.Bean.Po.Article;
import com.Project.blog.Bean.Vo.Article.VoArticle;
import com.Project.blog.Bean.Vo.Article.VoArticleSimple;
import com.Project.blog.Bean.Vo.User.VoUser;
import com.Project.blog.Bean.exception.BizException;
import com.Project.blog.Bean.exception.BizExceptionEnum;
import com.Project.blog.Bean.pageResult.PageRequest;
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
    //按照页号查询所有文章, 然后返回文章的简单视图
    @GetMapping("articles")
    public PageRequest<List<VoArticleSimple>> handle01(@RequestParam("page") int page , @RequestParam("size") int size){
        return articleService.getVoArticles(page, size);
    }




    //现在实现点击然后查看单一文章的详细内容
    @GetMapping("article/{id}")
    public VoArticle handle02(@PathVariable("id") Long id){
        return articleService.getArticleById(id);
    }

    //搜索所有User, 模糊匹配
    @GetMapping("search/users")
    public PageRequest<List<VoUser>> handle03(@RequestParam("keyword") String keyword, @RequestParam("page") int page, @RequestParam("size") int size){
        return userService.getVoUserByName_OnPage(keyword, page, size);
    }



    //----begin   点击User之后的全流程-----
    //1.展示User信息
    @GetMapping("user/{id}")
    public VoUser handle04(@PathVariable Long id){
        return userService.getVoUserById(id);
    }
    //2.展示本用户的所有文章, 简单展示 , 分页展示
    @GetMapping("user/articles/{user_id}")
    public PageRequest<List<VoArticleSimple>> handle05(@PathVariable("user_id") Long id, @RequestParam("page") int page, @RequestParam("size") int size){
        return articleService.getVoArticleSimple_ByUserId_Page(id, page, size);
    }
    //3.如果点击文章会触发文章查询, 也就是单id查询文章
    //这个时候再发一下handle02就好, 参数传递为点击的文章的id


    //-----end  --------

}
