package com.mavericsystems.gatewayservice.config;

import com.mavericsystems.gatewayservice.filter.JWTFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Autowired
    JWTFilter filter;
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes().route("authentication-authorization-service", r -> r.path("/auth/**").filters(f -> f.filter(filter)).uri("http://localhost:3000/"))
                .route("user-service", r -> r.path("/users/**").filters(f -> f.filter(filter)).uri("http://localhost:3005/"))
                .route("comment-service", r -> r.path("/posts/*/comments/**").filters(f -> f.filter(filter)).uri("http://localhost:3015/"))
                .route("post-service", r -> r.path("/posts/**").filters(f -> f.filter(filter)).uri("http://localhost:3010/"))
                .route("like-service", r -> r.path("/postsOrComments/**").filters(f -> f.filter(filter)).uri("http://localhost:3020/")).build();


    }
}