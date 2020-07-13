package com.yht.springcloud.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class NaCosConfigController {

    @Value("${config.info}")
    private String configValue;

    @GetMapping(value = "/config/info")
    public String configInfo(){
        return configValue;
    }
}
