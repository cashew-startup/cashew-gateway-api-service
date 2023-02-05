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
    private String gatewayEndpoint;
    private String microserviceEndpoint;
    private Boolean authRequired;

    @JsonCreator
    public EndpointCfg(
            @JsonProperty("id") final String id,
            @JsonProperty("gateway_endpoint") final String gatewayEndpoint,
            @JsonProperty("microservice_endpoint") final String microserviceEndpoint,
            @JsonProperty("auth_required") final Boolean authRequired
    ) {
        this.id = id;
        this.gatewayEndpoint = gatewayEndpoint;
        this.microserviceEndpoint = microserviceEndpoint;
        this.authRequired = authRequired;
    }

}
