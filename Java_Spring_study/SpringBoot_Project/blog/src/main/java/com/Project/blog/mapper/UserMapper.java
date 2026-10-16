package com.Project.blog.mapper;

import com.Project.blog.Bean.Po.User;
import com.Project.blog.Bean.Vo.User.VoUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    public VoUser getVoUserByCommentuserId(Long commentUserId);

    //姓名模糊匹配User, 返回VoUser

}
