package com.example.webcrawler.controller.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Website")
public class Website {

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    public Website() {
    }

    public Website(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Website(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Website{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
