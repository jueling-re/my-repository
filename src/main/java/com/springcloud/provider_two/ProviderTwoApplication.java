package com.springcloud.provider_two;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.springcloud.provider_two.dao")
public class ProviderTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderTwoApplication.class, args);
    }

}
