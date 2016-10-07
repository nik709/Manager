package com.netcracker.service;

import com.netcracker.domain.Category;

import java.util.List;

/**
 * Created by Никита on 05.09.2016.
 */
public interface CategoryService {

    public void add(Category category);

    public List<Category> list();

    public void remove(Integer id);

    public Category findById(Integer id);
}
