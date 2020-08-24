package com.example.webcrawler.controller.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Websites")
public class Website {

    @Id
    @GeneratedValue
    @Column(name = "website_id")
    private Integer id;
    private String title;

    @OneToMany(mappedBy="id")
    private Set<WebsiteLinks> links;

    public Website( String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
