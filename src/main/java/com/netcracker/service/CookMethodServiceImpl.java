package com.netcracker.service;

import com.netcracker.dao.CookMethodDAO;
import com.netcracker.dao.CookMethodDAOImpl;
import com.netcracker.domain.CookMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Никита on 06.09.2016.
 */
@Service
public class CookMethodServiceImpl implements CookMethodService {

    @Autowired
    private CookMethodDAO cookMethodDAO;

    @Transactional
    public void add(CookMethod cuisine) {
        cookMethodDAO.add(cuisine);
    }

    @Transactional
    public List<CookMethod> list() {
        return cookMethodDAO.list();
    }

    @Transactional
    public void remove(Integer id) {
        cookMethodDAO.remove(id);
    }

    @Transactional
    public CookMethod findById(Integer id){
        return cookMethodDAO.findById(id);
    }
}
