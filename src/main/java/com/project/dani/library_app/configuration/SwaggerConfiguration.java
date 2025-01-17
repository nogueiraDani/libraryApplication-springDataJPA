package com.project.dani.library_app.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {


    @Bean
    public GroupedOpenApi countryApi() {
        return GroupedOpenApi.builder().group("Country").pathsToMatch("/country/**")
                .build();
    }
    
    @Bean
    public GroupedOpenApi stateApi() {
        return GroupedOpenApi.builder().group("State").pathsToMatch("/state/**").build();
    }

    @Bean
    public GroupedOpenApi cityApi() {
        return GroupedOpenApi.builder().group("City").pathsToMatch("/city/**").build();
    }

    @Bean
    public GroupedOpenApi addressApi() {
        return GroupedOpenApi.builder().group("Address").pathsToMatch("/address/**").build();
    }
}
