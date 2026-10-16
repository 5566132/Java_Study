package com.Project.blog;

import com.Project.blog.Bean.Vo.User.VoUser;
import com.Project.blog.Bean.pageResult.PageRequest;
import com.Project.blog.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    UserMapper userMapper;


    @Test
    void contextLoads() {
        List<VoUser> list = userMapper.selectVoUserByName_OnPage("张", 0, 2);
        System.out.println(list);

    }

}
