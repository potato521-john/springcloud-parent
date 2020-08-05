package com.springcloud.yht.web;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        System.out.println("选中!");
        return "---------testA";
    }

    @SentinelResource("me")
    @GetMapping("/testC")
    public String testC(){
        System.out.println("选中C");
        return "----------------testC---------------";
    }

    @GetMapping("/testB")
    public String testB(){
        return "---------testB";
    }
}
