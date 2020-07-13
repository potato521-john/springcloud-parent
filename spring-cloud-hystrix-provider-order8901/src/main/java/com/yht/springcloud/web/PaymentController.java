package com.yht.springcloud.web;

import com.yht.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/payment/ok/{id}")
    public String payment_ok(@PathVariable(value = "id") Integer id){
        log.info("gateway网关动态路由到的服务器");
        return paymentService.payment_ok(id);
    }
    @GetMapping(value = "/payment/timeout/{id}")
    public String payment_timeout(@PathVariable(value = "id") Integer id){
        return paymentService.payment_timeout(id);
    }
}
