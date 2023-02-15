//package com.cashew.gatewayapi.router.microserviceConfig;
//
//import com.cashew.gatewayapi.router.RouterConfig;
//import com.cashew.gatewayapi.router.config.EndpointCfg;
//import com.cashew.gatewayapi.router.config.RouterCfg;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//public class UserBudgetConfig extends RouterConfig {
//
//    private final RouterCfg routerCfg;
//
//    @Autowired
//    public UserBudgetConfig(@Qualifier("UserBudgetRoutes") RouterCfg routerCfg) {
//        this.routerCfg = routerCfg;
//    }
//
//    @Bean
//    public RouteLocator userBudgetRoutes(RouteLocatorBuilder builder) {
//
//        RouteLocatorBuilder.Builder routesBuilder = builder.routes();
//
//        for (EndpointCfg endpointCfg : routerCfg.getEndpoints()) {
//            processEndpoint(routerCfg, endpointCfg, routesBuilder);
//        }
//        return routesBuilder.build();
//    }
//
//}
