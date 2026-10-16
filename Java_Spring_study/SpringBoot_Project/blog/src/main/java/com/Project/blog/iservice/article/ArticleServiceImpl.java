package com.Project.blog.iservice.article;

import com.Project.blog.Bean.Po.Article;
import com.Project.blog.Bean.Po.User;
import com.Project.blog.Bean.Vo.Article.VoArticle;
import com.Project.blog.Bean.Vo.Article.VoArticleSimple;
import com.Project.blog.Bean.Vo.Comment.VoComment;
import com.Project.blog.Bean.Vo.User.VoUser;
import com.Project.blog.Bean.exception.BizException;
import com.Project.blog.Bean.exception.BizExceptionEnum;
import com.Project.blog.Bean.pageResult.PageRequest;
import com.Project.blog.iservice.comment.CommentService;
import com.Project.blog.mapper.ArticleMapper;
import com.Project.blog.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.ldap.PagedResultsResponseControl;
import java.util.ArrayList;
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


/*
    @Override
    //查询所有文章但是必须分页,这个是粗略的展示文章信息
    //这个是按照页码查询所有的文章
    public List<VoArticleSimple> getArticlesByPage(int page, int size){
            page-=1;
            page = page * 4;

            List<Article> list = articleMapper.selectByPage(page, size);
            List<VoArticleSimple> ret = list.stream().map(s -> {
                VoArticleSimple vos = new VoArticleSimple();
                vos.setId(s.getId());
                vos.setName(s.getName());
                return vos;
            }).collect(Collectors.toList());
        return ret;
    }//这个分页写的不是最好的, 我写个新的,
*/

    @Override
    //就是全查询, 返回VoArticle 然后分页展示即可
    public PageRequest<List<VoArticleSimple>> getVoArticles(int page, int size){
        int offer = (page - 1) * size;

        PageRequest<List<VoArticleSimple>> ans = new PageRequest<>();
        ans.setPage(page);
        ans.setSize(size);

        List<VoArticleSimple> list = articleMapper.selectByPage(offer, size + 1);
        //还有下一页
        if(size < list.size()){
            ans.setHasMore(true);
            list = new ArrayList<>(list.subList(0,size));
        }else{
            ans.setHasMore(false);
        }
        ans.setData(list);

        return ans;
    }




    //单id查询文章, 我选择了用多个部分sql去拼凑出一个完整的VoArticle
    public VoArticle getArticleById(Long id){
        //用多个sql查一个视图

        //1 对, MP自带方法
        Article a1 = articleMapper.selectById(id);
/*
        //2 对
        User u1 = userMapper.selectById(a1.getUserId());

        //3 这个也对, 直接用User给VoUser赋值,
        VoUser vu = new VoUser();
        vu.setId(u1.getId());
        vu.setName(u1.getName());
        */
        VoUser vu = userMapper.selectVoUserById(a1.getUserId());


        //4 5 6
        //问题再这一行, 这里有两个CommentMapper层的方法可以用来查询一个文章的多个comment
        List<VoComment> commentsOfthisarticle = commentService.getCommentsByArticleId(a1.getId());
        VoArticle ans = new VoArticle();
        //ans.setBase(a1);
        ans.setAll(a1, vu, commentsOfthisarticle);
        return ans;
    }


    @Override
    //按照user_id查询指定的Article返回的是VoArticleSimple, 同时要求分页
    public PageRequest<List<VoArticleSimple>> getVoArticleSimple_ByUserId_Page(Long userId, int page, int size){
        int offset = (page - 1) * size;
        List<VoArticleSimple> list = articleMapper.selectVoArticleSimpleBy_UserId_Page(userId, offset, size + 1);
        PageRequest<List<VoArticleSimple>> ans = new PageRequest<>();
        ans.setPage(page);
        ans.setSize(size);
        //还有下一页
        if(list.size() > size){
            list = new ArrayList<>(list.subList(0, size));
            ans.setHasMore(true);
        }else{
            ans.setHasMore(false);
        }
        ans.setData(list);

        return ans;
    }



}
