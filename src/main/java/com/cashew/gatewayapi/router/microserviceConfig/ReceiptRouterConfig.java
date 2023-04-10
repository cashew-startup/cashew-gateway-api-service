package com.cashew.gatewayapi.router.microserviceConfig;

import com.cashew.gatewayapi.predicate.AuthPredicateFactory;
import com.cashew.gatewayapi.router.RouterConfig;
import com.cashew.gatewayapi.router.config.EndpointCfg;
import com.cashew.gatewayapi.router.config.RouterCfg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiptRouterConfig extends RouterConfig {

    private final RouterCfg routerCfg;

    private final AuthPredicateFactory authPredicate;

    @Autowired
    public ReceiptRouterConfig(@Qualifier("ReceiptRoutes") RouterCfg routerCfg, AuthPredicateFactory authPredicate) {
        this.routerCfg = routerCfg;
        this.authPredicate = authPredicate;
    }

    @Bean
    public RouteLocator receiptRoutes(RouteLocatorBuilder builder) {

        RouteLocatorBuilder.Builder routesBuilder = builder.routes();

        for (EndpointCfg endpointCfg : routerCfg.getEndpoints()) {
            processEndpoint(routerCfg, endpointCfg, routesBuilder, authPredicate);
        }
        return routesBuilder.build();
    }


}
