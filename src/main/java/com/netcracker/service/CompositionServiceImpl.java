package com.netcracker.service;

import com.netcracker.dao.CompositionDAO;
import com.netcracker.domain.Composition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Никита on 04.09.2016.
 */
@Service
public class CompositionServiceImpl implements CompositionService {

    @Autowired
    private CompositionDAO compositionDAO;

    @Transactional
    public void add(Composition composition) {
        compositionDAO.add(composition);
    }

    @Transactional
    public List<Composition> list() {
        return compositionDAO.list();
    }

    @Transactional
    public void remove(Integer id) {
        compositionDAO.remove(id);
    }
}
