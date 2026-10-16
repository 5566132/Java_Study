package com.Project.blog.Bean.Vo.Comment;

import com.Project.blog.Bean.Vo.User.VoUser;
import lombok.Data;

@Data
public class VoComment {

    //该评论的id
    private Long id;

    //评论的内容
    private String context;

    //评论的作者,直接用VoUser记录
    private VoUser voUser;




}
