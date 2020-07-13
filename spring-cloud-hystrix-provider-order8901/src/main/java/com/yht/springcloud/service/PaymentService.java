package com.yht.springcloud.service;

import com.yht.springcloud.service.fallback.PaymentServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "SPRING-CLOUD-HYSTRIX-PROVIDER",fallback = PaymentServiceFallback.class)
@Service
public interface PaymentService {
    @GetMapping(value = "/payment/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id);
}
