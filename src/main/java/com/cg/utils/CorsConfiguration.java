package com.cg.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

 

@Configuration
public class CorsConfiguration {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
                registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedHeaders("Access-Control-Allow-Credentials");
                registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedHeaders("Access-Control-Allow-Origin");
          
                registry.addMapping("/**").allowedOrigins();

            }
        };
    }
}