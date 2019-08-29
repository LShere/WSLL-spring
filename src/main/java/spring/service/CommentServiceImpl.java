package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.CommentDao;
import spring.pojo.Comment;

import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDao commentDao;

    public Integer addComment(Comment comment) {
        return commentDao.addComment(comment);
    }

}
