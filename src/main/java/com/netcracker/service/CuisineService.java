package com.netcracker.service;

import com.netcracker.domain.Cuisine;

import java.util.List;

/**
 * Created by Никита on 05.09.2016.
 */
public interface CuisineService {

    public void add(Cuisine cuisine);

    public List<Cuisine> list();

    public void remove(Integer id);

    public Cuisine findById(Integer id);
}
