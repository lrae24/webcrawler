package com.example.webcrawler.controller;

import com.example.webcrawler.controller.model.Website;
import com.example.webcrawler.repositories.WebsiteRepository;
import com.example.webcrawler.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
@Controller
public class HomeController {

    @Autowired
    WebsiteService websiteService;


    @GetMapping(path="/", produces = "application/json")
    public void findWebsite() throws IOException {
        websiteService.retrieveLinks("https://www.eagleford.co.za");
    }


}
