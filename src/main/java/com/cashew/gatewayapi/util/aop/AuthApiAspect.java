package com.cashew.gatewayapi.util.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Mono;

import java.lang.reflect.Method;

@Component
@Aspect
public class AuthApiAspect {

    @Around("execution(public * *(..)) && @annotation(com.cashew.gatewayapi.util.AuthNotRequired))")
    public Object authNotRequiredProcess(ProceedingJoinPoint call) throws Throwable {
        return call.proceed();
    }

    @Around("execution(public * *(..)) && @annotation(com.cashew.gatewayapi.util.AuthRequired))")
    public Object authRequiredProcess(ProceedingJoinPoint call) throws Throwable {
        MethodSignature signature = (MethodSignature) call.getSignature();
        Method method = signature.getMethod();
        PostMapping postMapping = method.getAnnotation(PostMapping.class);
        if (postMapping == null) { return Mono.just("annotation processor failed"); }
        String path = postMapping.value()[0];
        if (path == null) { return Mono.just("path is empty"); }
        System.out.println("path is " + path);
        Object[] args = call.getArgs();
        if (args == null) { return Mono.just("body doesn't exist"); }
        String json = (String) args[0];

        return call.proceed();
    }
}
