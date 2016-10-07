package com.netcracker.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Никита on 06.09.2016.
 */
@Entity
@Table (name = "recipes")
public class Recipe {

    @Id
    @Column (name = "Recipe_ID")
    private Integer id;

    @Column (name = "descript")
    private String descript;

    @Column (name = "name")
    private String name;

    @OneToOne
    private Category category;

    @OneToOne
    private Cuisine cuisine;

    @OneToOne
    private CookMethod method;

    @OneToOne
    private Time time;

    @Transient
    private String categoryString;

    @Transient
    private String cuisineString;

    @Transient
    private String methodString;

    @Transient
    private String timeString;

    @Transient
    private String[] ingredients;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public CookMethod getMethod() {
        return method;
    }

    public void setMethod(CookMethod method) {
        this.method = method;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (id != null ? !id.equals(recipe.id) : recipe.id != null) return false;
        if (descript != null ? !descript.equals(recipe.descript) : recipe.descript != null) return false;
        if (name != null ? !name.equals(recipe.name) : recipe.name != null) return false;
        if (category != null ? !category.equals(recipe.category) : recipe.category != null) return false;
        if (cuisine != null ? !cuisine.equals(recipe.cuisine) : recipe.cuisine != null) return false;
        if (method != null ? !method.equals(recipe.method) : recipe.method != null) return false;
        if (time != null ? !time.equals(recipe.time) : recipe.time != null) return false;
        return comments != null ? comments.equals(recipe.comments) : recipe.comments == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (descript != null ? descript.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (cuisine != null ? cuisine.hashCode() : 0);
        result = 31 * result + (method != null ? method.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", descript='" + descript + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", cuisine=" + cuisine +
                ", method=" + method +
                ", time=" + time +
                ", comments=" + comments +
                '}';
    }

    public String getCategoryString() {
        return categoryString;
    }

    public void setCategoryString(String categoryString) {
        this.categoryString = categoryString;
    }

    public String getCuisineString() {
        return cuisineString;
    }

    public void setCuisineString(String cuisineString) {
        this.cuisineString = cuisineString;
    }

    public String getMethodString() {
        return methodString;
    }

    public void setMethodString(String methodString) {
        this.methodString = methodString;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }
}
