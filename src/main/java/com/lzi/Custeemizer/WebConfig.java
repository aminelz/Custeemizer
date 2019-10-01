package com.lzi.Custeemizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry
                .addMapping("*")
                .allowedMethods("OPTIONS", "GET", "PUT", "POST", "DELETE")
                .allowedOrigins("*")
                .allowedHeaders("*");
    }
}