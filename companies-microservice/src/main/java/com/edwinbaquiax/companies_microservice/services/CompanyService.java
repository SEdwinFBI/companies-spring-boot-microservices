package com.edwinbaquiax.companies_microservice.services;

import com.edwinbaquiax.companies_microservice.entities.Category;
import com.edwinbaquiax.companies_microservice.entities.Company;
import com.edwinbaquiax.companies_microservice.entities.WebSite;
import com.edwinbaquiax.companies_microservice.repositories.ICompanyRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service //servicio
@Transactional //transacciones sql
@Slf4j //logs
@AllArgsConstructor
public class CompanyService implements ICompanyService {

    private final ICompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return this.companyRepository.findAll();
    }

    @Override
    public Company readByName(String name) {
        return this.companyRepository
                .findByName(name)
                .orElseThrow(()-> new NoSuchElementException("No companies found with name: " + name));
    }

    @Override
    public Company readById(long id) {
        return this.companyRepository
                .findById(id)
                .orElseThrow(()-> new NoSuchElementException("No companies found with id: " + id));
    }

    @Override
    public Company create(Company company) {

        company.getWebSites().forEach(webSiteArr -> {
            if(Objects.isNull(webSiteArr.getCategory())) {
                webSiteArr.setCategory(Category.NONE);
            }
        });
        return this.companyRepository.save(company);
    }

    @Override
    public Company update(Company company, long id) {
        var companyToUpdate= this.companyRepository
                .findById(id)
                .orElseThrow(()->
                        new NoSuchElementException("No companies found with id: " + id));

        companyToUpdate.setName(company.getName());
        //companyToUpdate.setWebSites(company.getWebSites());
        companyToUpdate.setLogo(company.getLogo());
        companyToUpdate.setFounder(company.getFounder());
        companyToUpdate.setFoundationDate(company.getFoundationDate());

        return this.companyRepository.save(companyToUpdate);
    }

    @Override
    public Company update(Company company, String name) {
        var companyToUpdate= this.companyRepository
                .findByName(name)
                .orElseThrow(()->
                        new NoSuchElementException("No companies found with name: " + name));

        //companyToUpdate.setName(company.getName());
        //companyToUpdate.setWebSites(company.getWebSites());
        companyToUpdate.setLogo(company.getLogo());
        companyToUpdate.setFounder(company.getFounder());
        companyToUpdate.setFoundationDate(company.getFoundationDate());
        return this.companyRepository.save(companyToUpdate);
    }

    @Override
    public void delete(long id) {
        var companyToUpdate= this.companyRepository
                .findById(id)
                .orElseThrow(()->
                        new NoSuchElementException("No companies found with id: " + id));
        this.companyRepository.delete(companyToUpdate);
    }

    @Override
    public void delete(String name) {
        var companyToUpdate= this.companyRepository
                .findByName(name)
                .orElseThrow(()->
                        new NoSuchElementException("No companies found with name: " + name));

        this.companyRepository.delete(companyToUpdate);
    }
}
