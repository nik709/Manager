package com.netcracker.service;

import com.netcracker.dao.CategoryDAO;
import com.netcracker.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Никита on 05.09.2016.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Transactional
    public void add(Category category) {
        categoryDAO.add(category);
    }

    @Transactional
    public List<Category> list() {
        return categoryDAO.list();
    }

    @Transactional
    public void remove(Integer id) {
        categoryDAO.remove(id);
    }
}
