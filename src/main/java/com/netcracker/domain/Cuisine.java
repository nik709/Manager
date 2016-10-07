package com.netcracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Никита on 05.09.2016.
 */

@Entity
@Table (name = "cuisines")
public class Cuisine {

    @Id
    @Column (name = "Cuisine_ID")
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
        return "Cuisine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cuisine cuisine = (Cuisine) o;

        if (id != null ? !id.equals(cuisine.id) : cuisine.id != null) return false;
        return name != null ? name.equals(cuisine.name) : cuisine.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Cuisine toCuisine(String cuisine){
        int startIndex = 0;
        int endIndex;
        String idS;

        while (cuisine.charAt(startIndex) != '=')
            startIndex++;
        startIndex++;
        endIndex = startIndex;

        while (cuisine.charAt(endIndex) != ',')
            endIndex++;
        idS = cuisine.substring(startIndex, endIndex);
        id = Integer.valueOf(idS);
        startIndex = endIndex;

        while (cuisine.charAt(startIndex) != '\'')
            startIndex++;
        startIndex++;
        endIndex = startIndex;

        while(cuisine.charAt(endIndex) != '}')
            endIndex++;
        name = cuisine.substring(startIndex, endIndex);

        return this;
    }
}
