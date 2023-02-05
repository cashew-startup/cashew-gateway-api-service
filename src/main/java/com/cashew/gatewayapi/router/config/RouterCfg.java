package com.cashew.gatewayapi.router.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RouterCfg {

    @JsonCreator
    public RouterCfg(@JsonProperty("endpoints") final List<EndpointCfg> endpoints) {
        this.endpoints = endpoints;
    }

    private String name;
    private ServiceCfg gateway;
    private ServiceCfg microservice;
    private List<EndpointCfg> endpoints;


    @JsonProperty("endpoints")
    public List<EndpointCfg> getEndpoint() {
        return endpoints;
    }

}
