package com.yht.springcloud;

import com.yht.springcloud.entities.Student;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication(exclude = {MybatisAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = "com.yht.springcloud.mapper")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }


    @Test
    public void test(){
        BeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName("student");
        ((RootBeanDefinition) beanDefinition).setBeanClass(Student.class);
    }
}
