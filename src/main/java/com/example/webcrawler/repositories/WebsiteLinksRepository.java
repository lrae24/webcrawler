package com.example.webcrawler.repositories;

import com.example.webcrawler.controller.model.WebsiteLinks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface WebsiteLinksRepository extends JpaRepository<WebsiteLinks, Long> {

    public List<WebsiteLinks> findByWebsiteId(long websiteId);
}
