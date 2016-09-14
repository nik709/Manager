package com.netcracker.service;

import com.netcracker.dao.CommentDAO;
import com.netcracker.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Никита on 06.09.2016.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Transactional
    public void add(Comment comment) {
        commentDAO.add(comment);
    }

    @Transactional
    public List<Comment> list() {
        return commentDAO.list();
    }

    @Transactional
    public void remove(Integer id) {
        commentDAO.remove(id);
    }
}
