package com.netcracker.dao;

import com.netcracker.domain.Cuisine;
import org.springframework.stereotype.Repository;

/**
 * Created by Никита on 05.09.2016.
 */
@Repository
public class CuisineDAOImpl extends BaseDAOImpl<Cuisine> implements CuisineDAO {

    public CuisineDAOImpl(){
        super(Cuisine.class);
    }
}
