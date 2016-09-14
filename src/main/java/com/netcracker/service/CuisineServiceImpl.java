package com.netcracker.service;

import com.netcracker.dao.CuisineDAO;
import com.netcracker.domain.Cuisine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Никита on 05.09.2016.
 */
@Service
public class CuisineServiceImpl implements CuisineService {

    @Autowired
    private CuisineDAO cuisineDAO;

    @Transactional
    public void add(Cuisine cuisine) {
        cuisineDAO.add(cuisine);
    }

    @Transactional
    public List<Cuisine> list() {
        return cuisineDAO.list();
    }

    @Transactional
    public void remove(Integer id) {
        cuisineDAO.remove(id);
    }

    @Transactional
    public Cuisine findById(Integer id){
        return cuisineDAO.findById(id);
    }
}
