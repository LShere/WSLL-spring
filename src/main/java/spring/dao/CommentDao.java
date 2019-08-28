package spring.dao;

import spring.pojo.Comment;

import java.util.List;
import java.util.Map;

public interface CommentDao {
    public Integer addComment(Comment comment);

    public List getCommentList();
}
