package com.yht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudStreamConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudStreamConsumerApplication.class, args);
    }
}
