package com.netcracker.service;

import com.netcracker.dao.RecipeDAO;
import com.netcracker.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Никита on 06.09.2016.
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeDAO recipeDAO;

    @Transactional
    public void add(Recipe recipe) {
        recipeDAO.add(recipe);
    }

    @Transactional
    public List<Recipe> list() {
        return recipeDAO.list();
    }

    @Transactional
    public void remove(Integer id) {
        recipeDAO.remove(id);
    }

    @Transactional
    public Recipe findById(Integer id) {
        return recipeDAO.findById(id);
    }

    @Transactional
    public List<Recipe> findByTime(Time time){
        return recipeDAO.findByTime(time);
    }

    @Transactional
    public List<Recipe> findByIngredients(ArrayList<Ingredient> ingredientList){
        return recipeDAO.findByIngredients(ingredientList);
    }

    @Transactional
    public List<Recipe> findByMethod(CookMethod cookMethod){
        return recipeDAO.findByMethod(cookMethod);
    }

    @Transactional
    public List<Recipe> findByCuisine(Cuisine cuisine){
        return recipeDAO.findByCuisine(cuisine);
    }
}
