package com.project.hirecar.application;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("locations-api").apiInfo(apiInfo()).select().paths(path()).build();
    }

    private Predicate<String> path() {
        return regex("/locations.*");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Hire Car API")
                .description("API reference for client renting a car")
                .version("1.0").build();
    }
}
