package com.example.webcrawler.service;

import com.example.webcrawler.controller.model.Website;
import com.example.webcrawler.controller.model.WebsiteLinks;
import com.example.webcrawler.repositories.WebsiteLinksRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class WebsiteLinksService {

    @Autowired
    WebsiteLinksRepository websiteLinksRepository;


//    public List<WebsiteLinks> findWebLinks(Website websiteId){
//      List<WebsiteLinks> allLinks =  websiteLinksRepository.findALLByWebsiteId(websiteId);
//        return allLinks;
//    }


    public HashSet<WebsiteLinks> getlinks(String URL, Website site) throws IOException {
        HashSet<WebsiteLinks> urls = new HashSet<>();
        Document document = Jsoup.connect(URL).get();
        Elements linksOnPage = document.select("a[href]");
        for (Element link : linksOnPage) {
            String links = link.attr("abs:href");
            if(links.contains("sedna.com")){
            urls.add(new WebsiteLinks(links,site));
            WebsiteLinks websitelink = new WebsiteLinks(links, site);
            websiteLinksRepository.save(websitelink);
            }
        }
        return urls;
    }


   public Map<Website,List<String>> retrieveVisitedWebsites(List<Website> websites){
       Map<Website,List<String>> visitedWebsites = new HashMap<>();
       List<String> linksOnly = new ArrayList<>();
       Website currentSite = null;
        for(Website site: websites){
            currentSite = site;
           List<WebsiteLinks> links =  websiteLinksRepository.findALLByWebsiteId(site);
           for(WebsiteLinks link: links)
               linksOnly.add(link.getLink());
        }
       visitedWebsites.put(currentSite,linksOnly );
        return visitedWebsites;
   }



      /*  public HashSet<String> getImages(String URL, Website site) throws IOException {
            HashSet<String> urls = new HashSet<>();
            Document document = Jsoup.connect(URL).get();
            Elements linksOnPage = document.select("[src]");
            for(Element imageSource: linksOnPage){
                String links =  imageSource.attr("abs:href");
                String image =  link.attr("abs:href");
                urls.add(links);
                WebsiteLinks websitelink = new WebsiteLinks(links, site);
                System.out.println(websitelink.toString());
                websiteLinksRepository.save(websitelink);
            }*/
}
