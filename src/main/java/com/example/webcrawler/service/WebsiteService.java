package com.example.webcrawler.service;

import com.example.webcrawler.controller.model.Website;

import com.example.webcrawler.repositories.WebsiteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class WebsiteService {

    @Autowired
    WebsiteRepository websiteRepository;


    public Website saveWebsite(String URL)  {
        Website site = new Website(URL);
        site = websiteRepository.save(site);
        return site;
    }

    public List<Website> retrieveAllWebsites() {
       return  websiteRepository.findAll();
    }



}
