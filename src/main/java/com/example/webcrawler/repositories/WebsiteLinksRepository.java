package com.example.webcrawler.repositories;

import com.example.webcrawler.controller.model.Website;
import com.example.webcrawler.controller.model.WebsiteLinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebsiteLinksRepository extends JpaRepository<WebsiteLinks, Long> {
    List<WebsiteLinks> findALLByWebsiteId(Website websiteId);
}
