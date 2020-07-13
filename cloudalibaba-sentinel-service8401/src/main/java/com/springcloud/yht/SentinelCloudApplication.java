package com.springcloud.yht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelCloudApplication.class,args);
    }
}
