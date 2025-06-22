package com.edwinbaquiax.companies_microservice.services;

import com.edwinbaquiax.companies_microservice.entities.Company;

import java.util.List;

public interface ICompanyService {

    List<Company> findAll();
    Company readByName(String name);
    Company readById(long id);

    Company create(Company company);

    Company update(Company company,long id);
    Company update(Company company,String name);

    void delete(long id);
    void delete(String name);
}

