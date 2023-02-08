package com.cashew.gatewayapi.router;

import com.cashew.gatewayapi.router.config.RouterCfg;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
@Slf4j
public class RouterCfgParser {

    @Bean("AuthRoutes")
    public RouterCfg authRouterCfg(ObjectMapper objectMapper)  {
        String relativePath = "src/main/resources/routes/auth_routes_v1.json";
        return getRouterCfg(objectMapper, relativePath);
    }

    @Bean("UserBudgetRoutes")
    public RouterCfg userBudgetRouterCfg(ObjectMapper objectMapper)  {
        String relativePath = "src/main/resources/routes/user_budget_routes_v1.json";
        return getRouterCfg(objectMapper, relativePath);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    private RouterCfg getRouterCfg(ObjectMapper objectMapper, String relativePath) {
        String path = Paths.get(new File(relativePath).getAbsolutePath()).toString();
        String json = null;
        try {
            json = readFileAsString(path);
        } catch (Exception e) {
            log.error("get path exception", e);
        }
        if (json == null) return null;

        try {
            return objectMapper.readValue(json, RouterCfg.class);
        } catch (JsonProcessingException e) {
            log.error("json parse exception", e);
        }
        return null;
    }

    public static String readFileAsString(String file)throws Exception {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

}
