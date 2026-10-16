package com.Project.blog.iservice.user;

import com.Project.blog.Bean.Po.User;
import com.Project.blog.Bean.Vo.User.VoUser;
import com.Project.blog.Bean.pageResult.PageRequest;
import com.Project.blog.mapper.UserMapper;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public PageRequest<List<VoUser>> getVoUserByName_OnPage(String keyword, int page, int size){
        int offset = (page - 1)*size;
        List<VoUser> list = userMapper.selectVoUserByName_OnPage(keyword, offset, size);
        PageRequest<List<VoUser>> pr = new PageRequest<>();
        pr.setSize(size);
        pr.setPage(page);
        pr.setData(list);
        if(list.size() == size){
            pr.setHasMore(true);
        }else{
            pr.setHasMore(false);
        }
        return pr;
    }

    @Override
    public VoUser getVoUserById(Long id){
        return userMapper.selectVoUserById(id);
    }

}
