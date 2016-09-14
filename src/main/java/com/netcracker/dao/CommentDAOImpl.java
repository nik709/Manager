package com.netcracker.dao;

import com.netcracker.domain.Comment;
import org.springframework.stereotype.Repository;

/**
 * Created by Никита on 06.09.2016.
 */
@Repository
public class CommentDAOImpl extends BaseDAOImpl<Comment> implements CommentDAO {

    public CommentDAOImpl(){
        super(Comment.class);
    }
}
