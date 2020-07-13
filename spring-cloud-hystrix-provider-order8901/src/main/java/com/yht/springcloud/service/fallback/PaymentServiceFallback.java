package com.yht.springcloud.service.fallback;

import com.yht.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/fallback")
public class PaymentServiceFallback implements PaymentService {
    @Override
    public String payment_ok(Integer id) {
        return "网络超时,请稍后重试!";
    }

    @Override
    public String payment_timeout(Integer id) {
        return "网络超时,请稍后重试!";
    }
}
