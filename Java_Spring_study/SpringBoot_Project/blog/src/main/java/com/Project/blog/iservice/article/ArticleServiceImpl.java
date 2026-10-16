package com.Project.blog.iservice.article;

import com.Project.blog.Bean.Po.Article;
import com.Project.blog.Bean.Po.User;
import com.Project.blog.Bean.Vo.Article.VoArticle;
import com.Project.blog.Bean.Vo.Article.VoArticleSimple;
import com.Project.blog.Bean.Vo.Comment.VoComment;
import com.Project.blog.Bean.Vo.User.VoUser;
import com.Project.blog.Bean.exception.BizException;
import com.Project.blog.Bean.exception.BizExceptionEnum;
import com.Project.blog.iservice.comment.CommentService;
import com.Project.blog.mapper.ArticleMapper;
import com.Project.blog.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService{

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CommentService commentService;



    @Override
    //查询所有文章但是必须分页,这个是粗略的展示文章信息
    public List<VoArticleSimple> getArticleByPage(int page){
            page-=1;
            page = page * 4;

            List<Article> list = articleMapper.selectByPage(page);
            List<VoArticleSimple> ret = list.stream().map(s -> {
                VoArticleSimple vos = new VoArticleSimple();
                vos.setId(s.getId());
                vos.setName(s.getName());
                return vos;
            }).collect(Collectors.toList());
        return ret;
    }

    //单id查询文章
    public VoArticle getArticleById(Long id){
        //用多个sql查一个视图

        //1 对
        Article a1 = articleMapper.selectById(id);

        //2 对
        User u1 = userMapper.selectById(a1.getUserId());

        //3 这个也对, 直接用User给VoUser赋值,
        VoUser vu = new VoUser();
        vu.setId(u1.getId());
        vu.setName(u1.getName());

        //4 5 6

        //问题再这一行
        List<VoComment> commentsOfthisarticle = commentService.getCommentByArticleId(id);
        VoArticle ans = new VoArticle();
        //ans.setBase(a1);


        ans.setAll(a1, vu, commentsOfthisarticle);
        return ans;
    }


}
