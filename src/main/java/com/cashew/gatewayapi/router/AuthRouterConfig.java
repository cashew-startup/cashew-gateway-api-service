package com.cashew.gatewayapi.router;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthRouterConfig {

    @Bean
    public RouteLocator authRoutes(RouteLocatorBuilder builder) {
        return builder.routes()

                .route("", r -> r
                        .path("/uuid")
                        .uri("http://httpbin.org/uuid")
                )
                .build();
    }

}
