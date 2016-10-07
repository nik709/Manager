package com.netcracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Никита on 05.09.2016.
 */
@Entity (name = "categories")
@Table (name = "categories")
public class Category {

    @Id
    @Column (name = "Category_ID")
    private Integer id;

    @Column (name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        return name != null ? name.equals(category.name) : category.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Category toCategory(String category){
        int startIndex = 0;
        int endIndex;
        String idS;
        while (category.charAt(startIndex) != '=')
            startIndex++;
        startIndex++;
        endIndex = startIndex;
        while (category.charAt(endIndex) != ',')
            endIndex++;
        idS = category.substring(startIndex, endIndex);
        id = Integer.valueOf(idS);
        startIndex = endIndex;
        while (category.charAt(startIndex) != '\'')
            startIndex++;
        startIndex++;
        endIndex = startIndex;
        while(category.charAt(endIndex) != '}')
            endIndex++;
        name = category.substring(startIndex, endIndex);

        return this;
    }
}
