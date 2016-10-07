package com.netcracker.dao;

import com.netcracker.domain.Comment;
import com.netcracker.domain.Recipe;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Никита on 06.09.2016.
 */
@Repository
public class CommentDAOImpl extends BaseDAOImpl<Comment> implements CommentDAO {

    public CommentDAOImpl(){
        super(Comment.class);
    }
}
