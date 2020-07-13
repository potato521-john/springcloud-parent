package com.yht.springcloud.service;

import com.yht.springcloud.common.CommonResult;
import com.yht.springcloud.entities.Payment;

public interface PaymentService {
    CommonResult create(Payment payment);
    CommonResult getPaymentById(Long id);
}
