package com.example.webcrawler.controller;

import com.example.webcrawler.controller.model.Website;
import com.example.webcrawler.controller.model.WebsiteLinks;
import com.example.webcrawler.controller.model.WebsiteURL;
import com.example.webcrawler.service.WebsiteLinksService;
import com.example.webcrawler.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    WebsiteService websiteService;

    @Autowired
    WebsiteLinksService websiteLinksService;


    @GetMapping(path="/")
    public String showHomePage(Model model) throws IOException {
        model.addAttribute("websiteURL", new WebsiteURL());
      return "index.html";
    }

    @GetMapping(path="/websites")
    public String showWebsites(Model model) throws IOException {
      List<Website> visitedSites =  websiteService.retrieveAllWebsites();
        Map<Website,List<String>> websitesWithLinks = websiteLinksService.retrieveVisitedWebsites(visitedSites);
        model.addAttribute("webcollection", websitesWithLinks);
        model.addAttribute("websites", visitedSites);
        return "visitedWebsites";
    }

    @PostMapping(path="/websitecheck")
    public String findWebsite(WebsiteURL url, Model model) throws IOException {
        Website website = websiteService.saveWebsite(url.getURL());
        HashSet<WebsiteLinks> links = websiteLinksService.getlinks(url.toString(),website);
        model.addAttribute("website",website );
        model.addAttribute("websiteLinks",links );
        return "webpageDetails.html";
    }


}
