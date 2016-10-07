package com.netcracker.dao;

import com.netcracker.domain.Composition;
import org.springframework.stereotype.Repository;

/**
 * Created by Никита on 04.09.2016.
 */

@Repository
public class CompositionDAOImpl extends BaseDAOImpl<Composition> implements CompositionDAO {

    public CompositionDAOImpl(){
        super(Composition.class);
    }

    public void update(Composition composition){
        sessionFactory.getCurrentSession().update(composition);
    }
}
