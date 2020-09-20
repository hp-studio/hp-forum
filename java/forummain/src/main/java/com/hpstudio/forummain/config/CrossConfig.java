package com.hpstudio.forummain.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author mawen
 * @date 2020/9/17 10:11
 * @email 455766076@qq.com
 * @description 解决跨域
 */
@ConditionalOnProperty(havingValue = "true",value = "${overCross}")
@Configuration
public class CrossConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowCredentials(false)
                        .allowedMethods("GET", "POST")
                        .allowedOrigins("*");
            }
        };
    }
}
