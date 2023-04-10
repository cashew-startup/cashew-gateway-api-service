package com.cashew.gatewayapi.predicate;

import com.cashew.gatewayapi.router.config.EndpointCfg;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;

import java.util.Map;

@Component
@Slf4j
public class AuthPredicateFactory {

    private final ObjectMapper mapper = new ObjectMapper();

    public boolean apply(ServerWebExchange config, EndpointCfg cfg) {

        if (!cfg.getAuthRequired()) return true;

        ServerHttpRequest request = config.getRequest();
        HttpHeaders headers = request.getHeaders();

        HttpHeaders httpHeaders = new HttpHeaders();

        headers
                .toSingleValueMap()
                .entrySet()
                .stream()
                .forEach(it -> httpHeaders.set(it.getKey(), it.getValue()));

        HttpEntity entity = new HttpEntity(headers);

        RestTemplate restTemplate = new RestTemplate();

        String fooResourceUrl = "http://194.35.116.155:8081/api/auth/token/validate";
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.exchange(fooResourceUrl, HttpMethod.GET, entity, String.class);
        } catch (HttpClientErrorException e) {
            log.info("user is not authorized");
            return false;
        }

        Map<String, String> json = null;
        try {
            json = mapper.readValue(response.getBody(), Map.class);
        } catch (Exception e) {
            log.info("object mapper exception");
            return false;
        }

        if (!Boolean.parseBoolean(json.get("success")) || json.get("id") == null) {
            log.info("user is not authorized because success is: " + Boolean.parseBoolean(json.get("success")));
            return false;
        }

        log.info("user id: {}, role: {} is authorized", json.get("id"), json.get("role"));

        return true;
    }

}
