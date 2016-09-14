package com.netcracker.service;

import com.netcracker.domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Никита on 06.09.2016.
 */
public interface RecipeService {

    public void add(Recipe recipe);

    public List<Recipe> list();

    public void remove(Integer id);

    public Recipe findById(Integer id);

    public List<Recipe> findByTime(Time time);

    public List<Recipe> findByIngredients(ArrayList<Ingredient> ingredientList);

    public List<Recipe> findByMethod(CookMethod cookMethod);

    public List<Recipe> findByCuisine(Cuisine cuisine);

}
