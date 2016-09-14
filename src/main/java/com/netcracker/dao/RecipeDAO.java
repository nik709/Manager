package com.netcracker.dao;

import com.netcracker.domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Никита on 06.09.2016.
 */
public interface RecipeDAO extends BaseDAO<Recipe> {

    public List<Recipe> findByIngredients(ArrayList<Ingredient> ingredientList);

    public List<Recipe> findByTime(Time time);

    public List<Recipe> findByMethod(CookMethod cookMethod);

    public List<Recipe> findByCuisine(Cuisine cuisine);
}
