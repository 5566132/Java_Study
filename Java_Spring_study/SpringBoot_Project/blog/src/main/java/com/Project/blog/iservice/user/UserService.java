package com.Project.blog.iservice.user;

import com.Project.blog.Bean.Po.User;
import com.Project.blog.Bean.Vo.User.VoUser;
import com.Project.blog.Bean.pageResult.PageRequest;
import com.baomidou.mybatisplus.spring.service.IService;

import java.util.List;


public interface UserService extends IService<User> {
    public PageRequest<List<VoUser>> getVoUserByName_OnPage(String keyword, int page, int size);

    //根据id返回用户的简单视图VoUser
    public VoUser getVoUserById(Long id);


}


