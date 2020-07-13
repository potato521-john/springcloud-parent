package com.yht.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PaymentService {

    public String payment_ok(Integer id){
        log.info("负载均衡到的服务器");
        return "线程池: " + Thread.currentThread().getName() + "payment_ok,id" + id;
    }

    public String payment_timeout(Integer id){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("负载均衡到的服务器");
        return "线程池: " + Thread.currentThread().getName() + "payment_timeout,id" + id + "\t" + "耗时 :3秒";
    }
}

