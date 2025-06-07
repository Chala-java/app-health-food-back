package com.example.PedidosApp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean

    public WebMvcConfigurer corsConfigurer(){
        return  new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                WebMvcConfigurer.super.addCorsMappings(registry);
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173/" ,"http://localhost:5175/", "http://localhost:5177/"  )
                        .allowedMethods("GET","POST","PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }
}
