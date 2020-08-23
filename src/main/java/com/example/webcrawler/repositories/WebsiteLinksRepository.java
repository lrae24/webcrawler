package com.example.webcrawler.repositories;

import com.example.webcrawler.controller.model.WebsiteLinks;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WebsiteLinksRepository extends JpaRepository<WebsiteLinks, Long> {

}
