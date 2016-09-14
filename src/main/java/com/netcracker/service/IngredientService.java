package com.netcracker.service;

import com.netcracker.domain.Ingredient;

import java.util.List;

/**
 * Created by Никита on 04.09.2016.
 */
public interface IngredientService {

    public void add(Ingredient ingredient);

    public List<Ingredient> list();

    public void remove(Integer id);

    public Ingredient findById(Integer id);
}
