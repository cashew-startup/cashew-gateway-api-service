package com.cashew.gatewayapi.router.microserviceConfig;

import com.cashew.gatewayapi.router.config.EndpointCfg;
import com.cashew.gatewayapi.router.config.RouterCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AuthRouterConfig {

    @Qualifier("AuthRoutes")
    private RouterCfg routerCfg;

    @Autowired
    public AuthRouterConfig(RouterCfg routerCfg) {
        this.routerCfg = routerCfg;
    }

    @Bean
    public RouteLocator authRoutes(RouteLocatorBuilder builder) {

        RouteLocatorBuilder.Builder routesBuilder = builder.routes();

        for (EndpointCfg endpointCfg : routerCfg.getEndpoints()) {
            routesBuilder = processEndpoint(endpointCfg, routesBuilder);
        }

        return routesBuilder.build();
    }

//      return builder.routes()
//
//                .route("", r -> r
//                        .path("/uuid")
//                        .uri("http://httpbin.org/uuid")
//                )

    private RouteLocatorBuilder.Builder processEndpoint(EndpointCfg endpointCfg, RouteLocatorBuilder.Builder routeBuilder) {
        return routeBuilder
                .route(endpointCfg.getId(), route -> route
                        .path(endpointCfg.getGatewayEndpoint())
                        .uri(routerCfg.getMicroservice().getAddress() + ":" + routerCfg.getMicroservice().getPort() + endpointCfg.getMicroserviceEndpoint())
                );
    }

}
