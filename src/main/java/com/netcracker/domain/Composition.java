package com.netcracker.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Никита on 04.09.2016.
 */

@Entity
@Table (name = "compositions")
public class Composition {

    @Id
    @Column (name = "Comp_ID")
    private Integer id;

    @OneToMany
    private List<Ingredient> ingredient;

    @OneToOne
    private Recipe recipe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Ingredient> getIngredient() {
        return ingredient;
    }

    public void setIngredient(List<Ingredient> ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Composition that = (Composition) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ingredient != null ? !ingredient.equals(that.ingredient) : that.ingredient != null) return false;
        return recipe != null ? recipe.equals(that.recipe) : that.recipe == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ingredient != null ? ingredient.hashCode() : 0);
        result = 31 * result + (recipe != null ? recipe.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Composition{" +
                "id=" + id +
                ", ingredient=" + ingredient +
                ", recipe=" + recipe +
                '}';
    }
}
