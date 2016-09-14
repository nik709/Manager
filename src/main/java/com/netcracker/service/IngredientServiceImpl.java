package com.netcracker.service;

import com.netcracker.dao.IngredientDAO;
import com.netcracker.domain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Никита on 04.09.2016.
 */

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientDAO ingredientDAO;

    @Transactional
    public void add(Ingredient ingredient) {
        ingredientDAO.add(ingredient);
    }

    @Transactional
    public List<Ingredient> list() {
        return ingredientDAO.list();
    }

    @Transactional
    public void remove(Integer id) {
        ingredientDAO.remove(id);
    }

    @Transactional
    public Ingredient findById(Integer id){
        return ingredientDAO.findById(id);
    }
}
