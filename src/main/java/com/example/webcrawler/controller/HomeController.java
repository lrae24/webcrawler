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
import java.util.List;

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

    @GetMapping(path="/websites", produces = "application/json")
    public void showWebsites() throws IOException {
        websiteService.retrieveLinks("https://www.eagleford.co.za");
    }

    @PostMapping(path="/websitecheck", produces = "application/json")
    public String findWebsite(@ModelAttribute WebsiteURL url, Model model) throws IOException {
        Website website = websiteService.retrieveLinks(url.getURL());
        List<WebsiteLinks> weblinks = websiteLinksService.findWebLinks(website.getId());
        model.addAttribute("website",website );
        model.addAttribute("weblinks",weblinks );
        return "webpageDetails.html";
    }


}
