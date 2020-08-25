package com.example.webcrawler.controller.model;

import org.springframework.stereotype.Component;

@Component
public class WebsiteURL {
    private String URL;

    public WebsiteURL() {

    }
    public WebsiteURL(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
