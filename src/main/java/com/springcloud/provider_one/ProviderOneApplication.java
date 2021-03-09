package com.springcloud.provider_one;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.springcloud.provider_one.dao")
public class ProviderOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderOneApplication.class, args);
    }

}
