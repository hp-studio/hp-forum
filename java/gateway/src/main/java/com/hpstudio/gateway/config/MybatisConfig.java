package com.hpstudio.gateway.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author mawen
 * @date 2020/9/10 14:01
 * @email 455766076@qq.com
 */
@Configuration
public class MybatisConfig {

    @Primary
    @Bean
    public MybatisPlusProperties mybatisPlusProperties() {
        MybatisPlusProperties properties = new MybatisPlusProperties();
        String[] locations = {"classpath*:/mapper/*.xml"};
        properties.setMapperLocations(locations);

        properties.setCheckConfigLocation(true);

        properties.setConfiguration(mybatisConfiguration());
        properties.setGlobalConfig(globalConfig());
        return properties;
    }

    public MybatisConfiguration mybatisConfiguration() {
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setMapUnderscoreToCamelCase(false);
        return configuration;
    }

    public GlobalConfig globalConfig() {
        GlobalConfig config = new GlobalConfig();
        config.setBanner(false);
        return config;
    }
}
