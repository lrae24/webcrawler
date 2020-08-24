package com.example.webcrawler.controller.model;

import javax.persistence.*;

@Entity
@Table(name="website_links")
public class WebsiteLinks {

    @Id
    @GeneratedValue
    private Long id;

    private String link;

    @ManyToOne
    @JoinColumn(name="website_id")
    private Website websiteId;

    public WebsiteLinks( String link, Website websiteId) {
        this.link = link;
        this.websiteId = websiteId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Website getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Website websiteId) {
        this.websiteId = websiteId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
