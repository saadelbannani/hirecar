package com.project.hirecar.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan(basePackages = {"com.project.hirecar.mapper"})
@EnableJpaRepositories(basePackages = "com.project.hirecar.repository")
@EntityScan(basePackages = "com.project.hirecar.model")
public class SpirngBootApplicationRun extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(SpirngBootApplicationRun.class, args);
    }

}
