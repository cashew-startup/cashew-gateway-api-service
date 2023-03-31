package com.cashew.gatewayapi.router.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import static com.cashew.gatewayapi.router.RouterCfgParser.readFileAsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RouterCfgTest {

//    @Test
//    public void mappingTest() throws Exception {
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        String path = Paths.get(new File("src/main/resources/routes/auth_routes_v1.json").getAbsolutePath()).toString();
//        String json = readFileAsString(path);
//
//        RouterCfg routerCfg = objectMapper.readValue(json, RouterCfg.class);
//
//        ServiceCfg gateway = routerCfg.getGateway();
//        ServiceCfg microservice = routerCfg.getMicroservice();
//        List<EndpointCfg> endpoints = routerCfg.getEndpoints();
//
//        EndpointCfg endpoint0 = endpoints.get(0);
//        EndpointCfg endpoint1 = endpoints.get(1);
//        EndpointCfg endpoint2 = endpoints.get(2);
//        EndpointCfg endpoint3 = endpoints.get(3);
//
//        assertEquals("localhost", gateway.getAddress());
//        assertEquals("8080", gateway.getPort());
//
//        assertEquals("localhost", microservice.getAddress());
//        assertEquals("8081", microservice.getPort());
//
//        assertEquals("register", endpoint0.getId());
//        assertEquals("/api/auth/register", endpoint0.getMicroserviceEndpoint());
//
//        assertEquals("login", endpoint1.getId());
//        assertEquals("/api/auth/login", endpoint1.getMicroserviceEndpoint());
//
//        assertEquals("refresh", endpoint2.getId());
//        assertEquals("/api/auth/token/refresh", endpoint2.getMicroserviceEndpoint());
//
//        assertEquals("validate", endpoint3.getId());
//        assertEquals("/api/auth/token/validate", endpoint3.getMicroserviceEndpoint());
//    }

}
