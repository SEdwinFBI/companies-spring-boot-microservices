package com.edwinbaquiax.companies_microservice.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Companies Microservice Application",
                version = "1.0.0",
                description = "Management companies"

        )
)
public class OpenApiConfig {
        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                        .info(new io.swagger.v3.oas.models.info.Info()
                                .title("Companies Microservice API")
                                .description("DDocumentación profesional de la API de compañías")
                                .version("v1.0")
                                .contact(new Contact()
                                        .name("Edwin Baquix")
                                        .email("bauiaxfernando0@gmail.com")
                                        .url("https://edwinportafolio.netlify.app/"))
                                .license(new License()
                                        .name("Licencia MIT")
                                        .url("https://opensource.org/licenses/MIT")));
        }
}
