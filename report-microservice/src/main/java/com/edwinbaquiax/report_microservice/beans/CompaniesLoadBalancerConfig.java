package com.edwinbaquiax.report_microservice.beans;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@LoadBalancerClient(
        name = "companies-microservice",
        configuration = LoadBalancerConfiguration.class
)
public class CompaniesLoadBalancerConfig {
}
