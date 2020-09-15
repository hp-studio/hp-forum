package com.hpstudio.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Predicate;

/**
 * @author mawen
 * @date 2020/9/13 21:14
 * @email 455766076@qq.com
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/forum/**")
                        .filters(f -> f.hystrix(config -> config.setName("defaultHystrix")
                                .setFallbackUri("forward:/fallback")))
                        .uri("lb://forummain"))
                .build();
    }
}
