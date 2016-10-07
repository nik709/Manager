package com.netcracker.service;

import com.netcracker.domain.Comment;
import com.netcracker.domain.Recipe;

import java.util.List;

/**
 * Created by Никита on 06.09.2016.
 */
public interface CommentService {

    public void add(Comment comment);

    public List<Comment> list();

    public void remove(Integer id);

}
