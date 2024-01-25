package com.driver.models;

import com.driver.models.User;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    @CreationTimestamp
    private Date pubdate;

    @JoinColumn
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    private List<Image> imageList=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return pubdate;
    }

    public void setPubDate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public Blog() {
    }

    public Blog( String title, String content) {
        this.title = title;
        this.content = content;

    }

    public Blog(int id, String title, String content, Date pubdate, User user, List<Image> imageList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.pubdate = pubdate;
        this.user = user;
        this.imageList = imageList;
    }
}