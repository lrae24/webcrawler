package com.example.webcrawler.service;

import com.example.webcrawler.controller.model.Website;
import com.example.webcrawler.controller.model.WebsiteLinks;
import com.example.webcrawler.repositories.WebsiteLinksRepository;
import com.example.webcrawler.repositories.WebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;
@Service
public class WebsiteLinksService {

    @Autowired
    WebsiteLinksRepository websiteLinksRepository;

    public Website findWebsiteById(){
        return null;
    }


    public List<WebsiteLinks> findWebLinks(long websiteId){
      List<WebsiteLinks> allLinks =  websiteLinksRepository.findByWebsiteId(websiteId);
        return allLinks;
    }
}
