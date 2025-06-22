package com.edwinbaquiax.companies_microservice.controllers;

import com.edwinbaquiax.companies_microservice.entities.Company;
import com.edwinbaquiax.companies_microservice.services.ICompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "company")
@Slf4j //logger
@Tag(name = "Companies Resource")
public class CompanyController {
     private final ICompanyService companyService;


    @Operation(summary = "Get all companies")
    @GetMapping(path = "list")
    public ResponseEntity<List<Company>> FinALL(){
        log.info("GET all comapnies");

        return ResponseEntity.ok(this.companyService.findAll());
    }

     @Operation(summary = "Get a company with name")
     @GetMapping(path = "{name}")
     public ResponseEntity<Company> readByName(@PathVariable String name){
         log.info("GET comapny with {}: ", name);
        Company findCompany= companyService.readByName(name);
        return ResponseEntity.ok(findCompany);
     }

    @Operation(summary = "Get a company with id")
     @GetMapping(path = "id/{id}")
     public ResponseEntity<Company> readById(@PathVariable long id){
         log.info("GET comapny with id {}: ", id);
        Company findCompany= companyService.readById(id);
        return ResponseEntity.ok(findCompany);
     }

    @Operation(summary = "Post company from body")
     @PostMapping
     public ResponseEntity<Company> createCompany(@RequestBody Company company){
         log.info("Post comapny with {}: ", company.getName());
        URI companyCreate = URI.create(this.companyService.create(company).getName());
        return ResponseEntity.created(companyCreate).build();
     }

    @Operation(summary = "Put company with name")
     @PutMapping(path = "{name}")
     public ResponseEntity<Company> putCompany(
             @RequestBody Company company,
             @PathVariable String name)
     {
         log.info("Put comapny with {}: ", name);
        Company companyUpdate= this.companyService.update(company,name);
        return ResponseEntity.ok(companyUpdate);
     }
    @Operation(summary = "Put company with id")
     @PutMapping(path = "id/{id}")
     public ResponseEntity<Company> putCompanyById(
             @RequestBody Company company,
             @PathVariable long  id)
     {
         log.info("Put comapny  {}: ", id);
        Company companyUpdate= this.companyService.update(company,id);
        return ResponseEntity.ok(companyUpdate);
     }
    @Operation(summary = "Delete company with name")
    @DeleteMapping(path = "{name}")
    public ResponseEntity<?> deleteCompany(
            @PathVariable String name)
    {
        log.info("Delete comapny  {}: ", name);
        this.companyService.delete(name);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete company with id")
    @DeleteMapping(path = "id/{id}")
    public ResponseEntity<?> deleteCompanyId(
            @PathVariable long id)
    {
        log.info("Delete comapny  with {}: ", id);
        this.companyService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
