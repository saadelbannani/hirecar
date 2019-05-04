package com.project.hirecar.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.project.hirecar")
@EnableJpaRepositories(basePackages="com.project.hirecar.repository")
@EntityScan(basePackages="com.project.hirecar.model")
public class SpirngBootApplicationRun {

    public static void main(String[] args) {
        SpringApplication.run(SpirngBootApplicationRun.class, args);
    }
}
