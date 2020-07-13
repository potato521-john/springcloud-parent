package com.yht.springcloud.web;

import com.yht.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CloudStreamController {
    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping(value = "/send")
    public String send(){
        String message = "*********";
        return iMessageProvider.send(message);
    }
}
