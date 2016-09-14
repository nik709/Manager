package com.netcracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by Никита on 06.09.2016.
 */

@Entity
@Table(name ="comments")
public class Comment {

    @Id
    @Column(name = "Comment_ID")
    private Integer id;

    @Column(name = "DateOfAddition")
    private Date date;

    @Column(name = "message")
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != null ? !id.equals(comment.id) : comment.id != null) return false;
        if (date != null ? !date.equals(comment.date) : comment.date != null) return false;
        return message != null ? message.equals(comment.message) : comment.message == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", date=" + date +
                ", message='" + message + '\'' +
                '}';
    }
}
