package com.netcracker.service;

import com.netcracker.dao.TimeDAO;
import com.netcracker.domain.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Никита on 06.09.2016.
 */
@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    private TimeDAO timeDAO;

    @Transactional
    public void add(Time time) {
        timeDAO.add(time);
    }

    @Transactional
    public List<Time> list() {
        return timeDAO.list();
    }

    @Transactional
    public void remove(Integer id) {
        timeDAO.remove(id);
    }

    @Transactional
    public Time findById(Integer id){
        return timeDAO.findById(id);
    }
}
