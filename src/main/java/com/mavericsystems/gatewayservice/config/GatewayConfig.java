package com.mavericsystems.gatewayservice.config;

import com.mavericsystems.gatewayservice.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
//    @Autowired
//    JwtAuthenticationFilter filter;
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder) {
//        return routeLocatorBuilder.routes().route("authentication-authorization-service", r -> r.path("/auth/**").filters(f -> f.filter(filter)).uri("http://localhost:3000/"))
//                .route("user-service", r -> r.path("/users/**").filters(f -> f.filter(filter)).uri("http://localhost:3005/"))
//                .route("post-service", r -> r.path("/posts/**").filters(f -> f.filter(filter)).uri("http://localhost:3010/"))
//                .route("comment-service", r -> r.path("/comment/**").filters(f -> f.filter(filter)).uri("http://localhost:3015/"))
//                .route("like-service", r -> r.path("/postsOrComments/**").filters(f -> f.filter(filter)).uri("http://localhost:3020/")).build();

        return routeLocatorBuilder.routes()
                .route("user-service", rt -> rt.path("/users/**")
                        .uri("http://localhost:3005/"))
                .route("comment-service", rt -> rt.path("/posts/*/comments/**")
                        .uri("http://localhost:3015/"))
                .route("post-service", rt -> rt.path("/posts/**")
                        .uri("http://localhost:3010/"))
                .route("like-service", rt -> rt.path("/postsOrComments/**")
                        .uri("http://localhost:3020/"))
                .route("authentication-authorization-service", rt -> rt.path("/auth/**")
                        .uri("http://localhost:3000/"))
                .build();
    }
}