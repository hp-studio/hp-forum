package com.hpstudio.forummain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.hpstudio.forummain.mapper")
public class ForummainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForummainApplication.class, args);
    }

}
