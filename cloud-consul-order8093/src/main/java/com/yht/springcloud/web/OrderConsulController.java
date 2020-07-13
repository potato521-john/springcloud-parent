package com.yht.springcloud.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderConsulController {

    @Resource
    private RestTemplate restTemplate;

    private final static String url = "http://cloud-consul-provider/payment/consul";

    @GetMapping(value = "/order/consul")
    public String orderConsul(){
        return restTemplate.getForObject(url, String.class);
    }
}
