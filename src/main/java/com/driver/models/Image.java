package com.driver.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity

public class Image {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String dimensions;

    @JoinColumn
    @ManyToOne
    private Blog blog;

    public Image(String description, String dimensions) {
        this.description = description;
        this.dimensions = dimensions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }


}