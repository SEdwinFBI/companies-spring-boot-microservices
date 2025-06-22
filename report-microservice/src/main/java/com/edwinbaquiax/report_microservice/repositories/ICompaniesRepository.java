package com.edwinbaquiax.report_microservice.repositories;

import com.edwinbaquiax.report_microservice.beans.LoadBalancerConfiguration;
import com.edwinbaquiax.report_microservice.models.Company;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Configuration
@FeignClient(name = "companies-microservice",path = "/companies-microservice/api/v1")
@LoadBalancerClient(name = "companies-microservice",configuration = LoadBalancerConfiguration.class)
public interface ICompaniesRepository {

    @GetMapping("/company/{name}")
    Optional<Company> getByName(@PathVariable String name);
}
