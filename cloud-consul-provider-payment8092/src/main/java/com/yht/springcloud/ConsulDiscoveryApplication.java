package com.yht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulDiscoveryApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulDiscoveryApplication.class, args);
    }
}
