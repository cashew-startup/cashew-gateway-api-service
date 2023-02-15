package com.cashew.gatewayapi.router.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class EndpointCfg {

    private String id;
    private String microserviceEndpoint;

    @JsonCreator
    public EndpointCfg(
            @JsonProperty("id") final String id,
            @JsonProperty("microservice_endpoint") final String microserviceEndpoint
    ) {
        this.id = id;
        this.microserviceEndpoint = microserviceEndpoint;
    }

}
