package com.netcracker.dao;

import com.netcracker.domain.Ingredient;
import org.springframework.stereotype.Repository;

/**
 * Created by Никита on 04.09.2016.
 */

@Repository
public class IngredientDAOImpl extends BaseDAOImpl<Ingredient> implements IngredientDAO{

    public IngredientDAOImpl(){
        super(Ingredient.class);
    }
}
