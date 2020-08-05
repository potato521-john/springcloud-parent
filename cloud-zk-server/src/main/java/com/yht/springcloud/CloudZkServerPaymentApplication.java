package com.yht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudZkServerPaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudZkServerPaymentApplication.class, args);
    }
}
