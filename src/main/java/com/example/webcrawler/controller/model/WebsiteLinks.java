package com.example.webcrawler.controller.model;

import javax.persistence.*;

@Entity
@Table(name="WebsiteLinks")
public class WebsiteLinks {

    @Id
    @GeneratedValue
    @Column(name = "websitelinks_id")
    private Long id;

    private String link;

    @ManyToOne
    @JoinColumn(name="website_id", nullable=false)
    private Long websiteId;

    public WebsiteLinks( String link, Long websiteId) {
        this.link = link;
        this.websiteId = websiteId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Long websiteId) {
        this.websiteId = websiteId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
