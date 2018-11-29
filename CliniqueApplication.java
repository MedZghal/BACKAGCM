package com.perfectsolution.Clinique;

import org.springframework.boot.web.servlet.support.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.properties.*;
import com.perfectsolution.Clinique.Entities.*;
import org.springframework.boot.*;
import org.springframework.boot.web.server.*;
import org.springframework.boot.web.servlet.server.*;
import org.springframework.context.annotation.*;
import org.springframework.boot.builder.*;

@SpringBootApplication
@EnableConfigurationProperties({ FileStorageProperties.class })
public class CliniqueApplication extends SpringBootServletInitializer
{
    public static void main(final String[] args) {
        SpringApplication.run((Class)CliniqueApplication.class, args);
    }
    
    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
        return (WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>)(factory -> factory.setContextPath("/Clinique"));
    }
    
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(new Class[] { CliniqueApplication.class });
    }
}
