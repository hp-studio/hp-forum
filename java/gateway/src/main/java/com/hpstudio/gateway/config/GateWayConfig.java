package com.hpstudio.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.support.RouteMetadataUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
                        .uri("lb://forummain")
                        .metadata(RouteMetadataUtils.RESPONSE_TIMEOUT_ATTR, 5000)
                        .metadata(RouteMetadataUtils.CONNECT_TIMEOUT_ATTR, 2000))
                .build();
    }
}
