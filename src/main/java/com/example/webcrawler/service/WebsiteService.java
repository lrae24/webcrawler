package com.example.webcrawler.service;

import com.example.webcrawler.controller.model.Website;
import com.example.webcrawler.controller.model.WebsiteLinks;
import com.example.webcrawler.repositories.WebsiteLinksRepository;
import com.example.webcrawler.repositories.WebsiteRepository;
import jdk.internal.jline.internal.Urls;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

@Service
public class WebsiteService {

    @Autowired
    WebsiteRepository websiteRepository;


    public Website saveWebsite(String URL) throws IOException {
        Website site = new Website(URL);
        site = websiteRepository.save(site);
        return site;
    }

    public List<Website> retrieveAllWebsites() {
       return  websiteRepository.findAll();
    }



}
