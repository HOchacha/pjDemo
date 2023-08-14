package com.example.pjdemo;

import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.beans.factory.annotation.Value;
@SpringBootApplication
public class PjDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PjDemoApplication.class, args);
    }

}
