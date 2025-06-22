package com.edwinbaquiax.companies_microservice.repositories;

import com.edwinbaquiax.companies_microservice.entities.WebSite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWebSiteRepository extends JpaRepository<WebSite, Long> {
}
