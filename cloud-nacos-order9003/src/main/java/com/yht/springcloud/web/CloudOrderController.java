package com.yht.springcloud.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CloudOrderController {

    @Resource
    private RestTemplate restTemplate;

    private String requestUrl = "http://cloud-nacos-provider";

    @GetMapping(value = "/payment/ok/{id}")
    public String getOrder(@PathVariable("id") Long id){
        String order = restTemplate.getForObject(requestUrl + "/payment/ok/" + id, String.class);
        return order;
    }
}
