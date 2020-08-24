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

import java.io.IOException;
import java.util.HashSet;
@Service
public class WebsiteService {

    @Autowired
    WebsiteRepository websiteRepository;

    @Autowired
    WebsiteLinksRepository websiteLinksRepository;

    public Website retrieveLinks(String URL) throws IOException {
        HashSet<String> urls = new HashSet<>();
        Document document = Jsoup.connect(URL).get();
        Elements linksOnPage = document.select("a[href]");
        Website site = new Website(URL);
        websiteRepository.save(site);

        for(Element link: linksOnPage){
            urls.add(link.toString());
            WebsiteLinks websitelink = new WebsiteLinks(link.toString(), site);
            websiteLinksRepository.save(websitelink);
        }


        return site;
    }
}
