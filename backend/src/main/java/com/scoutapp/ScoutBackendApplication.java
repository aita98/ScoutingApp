package com.scoutapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class ScoutBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScoutBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner listEndpoints(ApplicationContext ctx) {
        return args -> {
            try {
                RequestMappingHandlerMapping mapping = ctx.getBean(RequestMappingHandlerMapping.class);
                mapping.getHandlerMethods().forEach((key, value) -> System.out.println(key + " : " + value));
            } catch (Exception e) {
                System.err.println("Error listing endpoints: " + e.getMessage());
            }
        };
    }
}
