package com.cashew.gatewayapi.router;

import com.cashew.gatewayapi.router.config.EndpointCfg;
import com.cashew.gatewayapi.router.config.RouterCfg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Slf4j
public class RouterConfig {

    public void processEndpoint(RouterCfg routerCfg, EndpointCfg endpointCfg, RouteLocatorBuilder.Builder routeBuilder) {
        log.info("microservice endpoint: {}",endpointCfg.getMicroserviceEndpoint());
        log.info("uri: {}", routerCfg.getUri());
        log.info("{}", "--------------------------------------------------------");
        routeBuilder
                .route(endpointCfg.getId(), route -> route
                        .path(endpointCfg.getMicroserviceEndpoint())
                        .uri(routerCfg.getUri())
                );
    }

}
