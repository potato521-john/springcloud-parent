package com.yht.springcloud.web;

import com.yht.springcloud.entities.TOrder;
import com.yht.springcloud.service.OrderService;
import com.yht.springcloud.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/order/create")
    public CommonResult create(TOrder order){
        orderService.create(order);
        return new CommonResult(200, "创建成功!");
    }

}
