package com.example.webcrawler.repositories;

import com.example.webcrawler.controller.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WebsiteRepository extends JpaRepository<Website, Integer> {

}
