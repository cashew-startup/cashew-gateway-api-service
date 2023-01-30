package com.cashew.gatewayapi.api;

import com.cashew.gatewayapi.service.AuthApiRedirector;
import com.cashew.gatewayapi.util.AuthNotRequired;
import com.cashew.gatewayapi.util.AuthRequired;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthApi {

    private AuthApiRedirector authApiRedirector;

    @AuthNotRequired
    @GetMapping("hello")
    public Mono<String> hello() {
        return Mono.just("hello");
    }

    @AuthRequired
    @GetMapping("hello2wtf")
    public Mono<String> hello2() {
        return Mono.just("hello2");
    }

    @AuthRequired
    @PostMapping("hello2wtf")
    public Mono<String> hello2post(@RequestBody String json) {

        return Mono.just("hello2");
    }

    @AuthNotRequired
    @PostMapping("/register")
    public Mono<String> register(@RequestBody String json) {
        return authApiRedirector.register(json);
    }

    @Autowired
    public void setAuthApiRedirector(AuthApiRedirector authApiRedirector) {
        this.authApiRedirector = authApiRedirector;
    }
}
