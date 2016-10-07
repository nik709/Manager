package com.netcracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Никита on 06.09.2016.
 */

@Entity
@Table (name = "cookmethod")
public class CookMethod {

    @Id
    @Column (name = "Method_ID")
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CookMethod that = (CookMethod) o;

        if (!id.equals(that.id)) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "СookMethod{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public CookMethod toCookMethod(String method){
        int startIndex = 0;
        int endIndex;
        String idS;
        while (method.charAt(startIndex) != '=')
            startIndex++;
        startIndex++;
        endIndex = startIndex;
        while (method.charAt(endIndex) != ',')
            endIndex++;
        idS = method.substring(startIndex, endIndex);
        id = Integer.valueOf(idS);
        startIndex = endIndex;
        while (method.charAt(startIndex) != '\'')
            startIndex++;
        startIndex++;
        endIndex = startIndex;
        while(method.charAt(endIndex) != '}')
            endIndex++;
        name = method.substring(startIndex, endIndex);

        return this;
    }
}
