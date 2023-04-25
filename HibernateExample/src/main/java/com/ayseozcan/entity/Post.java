package com.ayseozcan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tblposts")
public class Post {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private Date date = new Date();
    private Long userId;

    public Post() {
    }

    public Post( String content, Date date, Long userId) {
        this.content = content;
        this.date = date;
        this.userId = userId;
    }

    public Post(String content, Long userId) {
        this.content = content;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", userId=" + userId +
                '}';
    }
}
