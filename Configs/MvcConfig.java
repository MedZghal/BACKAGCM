package com.perfectsolution.Clinique.Configs;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter
{
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
    }
    
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins(new String[] { "*" });
    }
}
