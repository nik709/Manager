package com.netcracker.dao;

import com.netcracker.domain.Category;
import org.springframework.stereotype.Repository;

/**
 * Created by Никита on 05.09.2016.
 */
@Repository
public class CategoryDAOImpl extends BaseDAOImpl<Category> implements CategoryDAO {

    public CategoryDAOImpl(){
        super(Category.class);
    }
}
