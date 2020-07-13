package com.yht.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *@author  wkj
 * @creater 2020-05-22
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.yht.springcloud.mapper")
@Slf4j
public class PaymentApplication {
    public static void main(String[] args) {
        log.info("服务重启!");
        SpringApplication.run(PaymentApplication.class, args);
    }
}
