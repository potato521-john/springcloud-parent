package com.yht.springcloud.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {

    @GetMapping(value = "/payment/ok/{id}")
    public String getPayment(@PathVariable("id") Long id){
        log.info("负载均衡均衡到的服务器!");
        String payment = UUID.randomUUID().toString();
        return payment + "ok; + 订单id : " + id;
    }
}
