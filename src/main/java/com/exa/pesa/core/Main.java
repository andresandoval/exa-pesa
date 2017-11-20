package com.exa.pesa.core;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * Created by Andres on 24/9/2017.
 */

@SpringBootApplication
@EntityScan(basePackages = {"com.exa.pesa.core.persistence.entitities", "com.exa.pesa.core.persistence.converters"})
@EnableJpaRepositories(basePackages = {"com.exa.pesa.core.persistence.daos"})
@ComponentScan(basePackages = {
        "com.exa.pesa.core.config",
        "com.exa.pesa.core.security",
        "com.exa.pesa.core.services",
        "com.exa.pesa.core.controllers"
})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
