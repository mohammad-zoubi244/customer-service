package com.mohammadzoubi.microservices.customer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Customer Service APIs")
                        .version("1.0")
                        .description("API documentation for the Customer service APIs.")
                        .contact(new Contact().name("Mohammad Zoubi")));
    }

}
