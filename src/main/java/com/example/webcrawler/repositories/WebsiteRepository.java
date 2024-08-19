package com.example.webcrawler.repositories;

import com.example.webcrawler.controller.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteRepository extends JpaRepository<Website, Long> {

}
