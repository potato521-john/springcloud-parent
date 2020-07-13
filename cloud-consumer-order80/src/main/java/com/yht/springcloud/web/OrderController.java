package com.yht.springcloud.web;

import com.yht.springcloud.common.CommonResult;
import com.yht.springcloud.entities.Payment;
import com.yht.springcloud.lib.Loadbalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    private final static String url = "http://CLOUD-PROVIDER-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private Loadbalancer loadbalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/getPayment/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getPaymentById(@PathVariable Long id){
        return restTemplate.getForObject(url + "/pay/getPayment/" + id, CommonResult.class);
    }

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody Payment payment){
        CommonResult result = restTemplate.postForObject(url + "/insert", payment, CommonResult.class);
        return result;
    }

    @RequestMapping(value = "/consumer/payment.lb")
    @ResponseBody
    public String getPaymentLb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT-SERVICE");
        if(instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance instance = loadbalancer.instances(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/pay/getPayment/", String.class);
    }
}
