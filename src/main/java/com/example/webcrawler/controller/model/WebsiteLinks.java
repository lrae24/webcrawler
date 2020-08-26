package com.example.webcrawler.controller.model;

import javax.persistence.*;

@Entity
@Table(name="website_links")
public class WebsiteLinks {

    @Id
    @GeneratedValue
    private Long id;

    private String link;
    private String imgUrl;
    private long depth;
    private String relLinks;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="website_id")
    private Website websiteId;

    public WebsiteLinks() {

    }


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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public long getDepth() {
        return depth;
    }

    public void setDepth(long depth) {
        this.depth = depth;
    }

    public String getRelLinks() {
        return relLinks;
    }

    public void setRelLinks(String relLinks) {
        this.relLinks = relLinks;
    }

    @Override
    public String toString() {
        return "WebsiteLinks{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", depth=" + depth +
                ", relLinks='" + relLinks + '\'' +
                ", websiteId=" + websiteId +
                '}';
    }
}
