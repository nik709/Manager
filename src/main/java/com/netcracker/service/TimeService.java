package com.netcracker.service;

import com.netcracker.domain.Time;

import java.util.List;

/**
 * Created by Никита on 06.09.2016.
 */
public interface TimeService {

    public void add(Time time);

    public List<Time> list();

    public void remove(Integer id);

    public Time findById(Integer id);
}
