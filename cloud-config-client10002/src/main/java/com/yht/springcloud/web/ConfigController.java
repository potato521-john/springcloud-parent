package com.yht.springcloud.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ConfigController {
    @Value("config.value")
    private String configStr;

    @GetMapping(value = "/getConfigValue")
    public String getConfig(){
        log.info(configStr);
        return configStr;
    }
}
