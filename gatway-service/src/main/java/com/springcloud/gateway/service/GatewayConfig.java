package com.springcloud.gateway.service;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableHystrix
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
//        https://rapidapi.com/apilayernet/api/rest-countries-v1
                .route(p -> p
                        .path("/all")
                        .filters(f ->
                                f.addRequestHeader("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
                                        .addRequestHeader("x-rapidapi-key", "de45bf22femsha486f03cae5dae7p187cacjsn1ad258460e85")
                        )
                        .uri("https://restcountries-v1.p.rapidapi.com")
                )

                .route(p -> p
                        .path("/joke/Any")
                        .filters(f ->
                                f.addRequestHeader("x-rapidapi-host", "jokeapi-v2.p.rapidapi.com")
                                 .addRequestHeader("x-rapidapi-key", "de45bf22femsha486f03cae5dae7p187cacjsn1ad258460e85")
                        )
                        .uri("https://jokeapi-v2.p.rapidapi.com")
                ).build();

/*                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f.hystrix(config -> config.setName("mycmd")))
                        .uri("http://httpbin.org:80")).
                        build();*/
    }
}
