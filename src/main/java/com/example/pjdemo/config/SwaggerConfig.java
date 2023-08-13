package com.example.pjdemo.config;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.resource.jdbc.ResourceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
    private static final String SERVICE_NAME = "REST API Project";
    private static final String API_VERSION = "V1";
    private static final String API_DESCRIPTION = "REST API TEST";
    private static final String API_URL = "http://localhost:8080/";
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("example.org/api")
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("API")
                .description("[Hochacha] REST API")
                .contact(new Contact("[DDaja Swagger]", "https://github.com/Hochacha", "BNG"))
                .version("1.0")
                .build();
    }
}