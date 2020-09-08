package com.hpstudio.forummain.config;

import com.hpstudio.forummain.entity.DataSourceEntity;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author mawen
 * @date 2020/9/8 21:17
 * @email 455766076@qq.com
 */
@Configuration
public class DataSourceConfig {
    @Autowired
    private DataSourceEntity entity;

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(entity.getUrl());
        dataSource.setDriverClassName(entity.getDriver());
        dataSource.setUsername(entity.getUserName());
        dataSource.setPassword(entity.getPassword());
        return dataSource;
    }
}
