package com.edwinbaquiax.companies_microservice.repositories;

import com.edwinbaquiax.companies_microservice.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByName(String name);

}
