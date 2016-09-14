package com.netcracker.dao;

import com.netcracker.domain.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Никита on 06.09.2016.
 */
@Repository
public class RecipeDAOImpl extends BaseDAOImpl<Recipe> implements RecipeDAO {

    public RecipeDAOImpl(){
        super(Recipe.class);
    }

    public List<Recipe> findByTime(Time time){

        String query = "from Recipe where time_time_id = " + time.getId();

        return sessionFactory.getCurrentSession().createQuery(query).list();
    }

    public List<Recipe> findByIngredients(ArrayList<Ingredient> ingredientList){

        List<Composition> compositions;
        String query = "from Composition";
        compositions = sessionFactory.getCurrentSession().createQuery(query).list();

        ArrayList<Recipe> recipes = new ArrayList<Recipe>();

        for (Composition composition:compositions){
            List<Ingredient> ingredients = composition.getIngredient();
            for (Ingredient ingr:ingredientList){
                if (ingredients.contains(ingr))
                    recipes.add(composition.getRecipe());
            }
        }

        return recipes;
    }

    public List<Recipe> findByMethod(CookMethod cookMethod){

        String query = "from Recipe where method_method_id = " + cookMethod.getId();

        return  sessionFactory.getCurrentSession().createQuery(query).list();
    }

    public List<Recipe> findByCuisine(Cuisine cuisine){

        String query = "from Recipe where cuisine_cuisine_id = " + cuisine.getId();

        return sessionFactory.getCurrentSession().createQuery(query).list();
    }
}
