package spring.service;

import spring.pojo.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {
    public Integer addComment(Comment comment);

    public List getCommentList();


}
