package com.hpstudio.forummain.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author mawen
 * @date 2020/9/9 10:29
 * @email 455766076@qq.com
 */
@Configuration
public class MybatisConfig {

    @Primary
    @Bean
    public MybatisPlusProperties mybatisPlusProperties() {
        MybatisPlusProperties properties = new MybatisPlusProperties();
        String[] locations = {"classpath*:/mapper/*.xml"};
        //配置xml路径
        properties.setMapperLocations(locations);
        //启动检查xml是否存在
        properties.setCheckConfigLocation(true);

        properties.setConfiguration(mybatisConfiguration());
        properties.setGlobalConfig(globalConfig());
        return properties;
    }

    //分页插件
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    public MybatisConfiguration mybatisConfiguration() {
        MybatisConfiguration configuration = new MybatisConfiguration();
        //数据库按小驼峰命名，关闭自动下划线驼峰
        configuration.setMapUnderscoreToCamelCase(false);
        return configuration;
    }

    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        //去除图标
        globalConfig.setBanner(false);
        return globalConfig;
    }
}
