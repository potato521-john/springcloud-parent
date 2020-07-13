package com.yht.springcloud.web;

import com.yht.springcloud.common.CommonResult;
import com.yht.springcloud.entities.Payment;
import com.yht.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/pay")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    @ResponseBody
    public CommonResult<Payment> create(@RequestBody Payment payment){
        log.info("插入数据库数据!用到的端点服务器是-->" + serverPort);
        return paymentService.create(payment);
    }

    @RequestMapping(value = "/getPayment/{id}")
    @ResponseBody
    public CommonResult<Payment> getPayment(@PathVariable Long id){
        log.info("获得数据库数据!用到的端点服务器是-->" + serverPort);
        return paymentService.getPaymentById(id);
    }

    @RequestMapping("/payment/discover")
    @ResponseBody
    public Object discover(){
        List<String> servicesList = discoveryClient.getServices();
        servicesList.forEach(service->{
            log.info("打印结果: " + service);
        });
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("cloud-provider-payment-service");
        serviceInstanceList.forEach(serviceInstance -> {
            log.info("主机: " + serviceInstance.getHost());
            log.info("实例名字: " + serviceInstance.getInstanceId());
            log.info("Secheme配置: " + serviceInstance.getScheme());
            log.info("端口号: " + serviceInstance.getPort());
            log.info("uri" + serviceInstance.getUri().getPath());
        });
        return null;
    }
}
