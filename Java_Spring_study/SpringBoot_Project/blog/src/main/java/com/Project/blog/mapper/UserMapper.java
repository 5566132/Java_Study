package com.Project.blog.mapper;

import com.Project.blog.Bean.Po.User;
import com.Project.blog.Bean.Vo.User.VoUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    //public VoUser selectVoUserByCommentuserId(Long commentUserId);

    //姓名模糊匹配User, 返回一堆VoUser
    public List<VoUser> selectVoUserByName_OnPage(@Param("keyword") String keyword, @Param("offset") int offset , @Param("size") int size);


    //根据用户的id直接匹配用户, 返回VoUser
    public VoUser selectVoUserById(@Param("id") Long id);



}
