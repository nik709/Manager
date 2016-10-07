package com.netcracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Никита on 06.09.2016.
 */
@Entity (name = "time")
@Table (name = "time")
public class Time {

    @Id
    @Column (name = "Time_ID")
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
        return "Time{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        if (id != null ? !id.equals(time.id) : time.id != null) return false;
        return name != null ? name.equals(time.name) : time.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Time toTime(String time){
        int startIndex = 0;
        int endIndex;
        String idS;
        while (time.charAt(startIndex) != '=')
            startIndex++;
        startIndex++;
        endIndex = startIndex;
        while (time.charAt(endIndex) != ',')
            endIndex++;
        idS = time.substring(startIndex, endIndex);
        id = Integer.valueOf(idS);
        startIndex = endIndex;
        while (time.charAt(startIndex) != '\'')
            startIndex++;
        startIndex++;
        endIndex = startIndex;
        while(time.charAt(endIndex) != '}')
            endIndex++;
        name = time.substring(startIndex, endIndex);

        return this;
    }
}
