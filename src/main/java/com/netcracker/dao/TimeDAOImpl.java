package com.netcracker.dao;

import com.netcracker.domain.Time;
import org.springframework.stereotype.Repository;

/**
 * Created by Никита on 06.09.2016.
 */
@Repository
public class TimeDAOImpl extends BaseDAOImpl<Time> implements TimeDAO {

    public TimeDAOImpl(){
        super(Time.class);
    }
}
