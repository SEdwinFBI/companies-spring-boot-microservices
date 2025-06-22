package com.edwinbaquiax.report_microservice.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
public class LoadBalancerConfiguration {
    @Bean
    public ServiceInstanceListSupplier getServiceInstanceListSupplier(ConfigurableApplicationContext context) {
        log.info("Configurando el LoadBalancer");

        return  ServiceInstanceListSupplier.builder()
                .withBlockingDiscoveryClient()
                .build(context);
    }
}
