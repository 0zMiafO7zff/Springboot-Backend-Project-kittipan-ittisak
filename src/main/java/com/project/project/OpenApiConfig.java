package com.project.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openProjectApi(){
        return new OpenAPI()
        .info(new Info()
            .title("Project Ice Factory-Kittipan J. & Ittisak S.")
            .description("API Backend")
            .version("1.0")
        );
    }
}
