package com.hpstudio.forummain.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author mawen
 * @date 2020/9/8 21:26
 * @email 455766076@qq.com
 */
@Component
@ConfigurationProperties(prefix = "datasource.config.master")
@Data
public class DataSourceEntity {
    private String url;

    private String driver;

    private String userName;

    private String password;
}
