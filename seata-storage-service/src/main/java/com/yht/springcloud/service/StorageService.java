package com.yht.springcloud.service;

import com.yht.springcloud.utils.CommonResult;
import org.springframework.web.bind.annotation.RequestParam;

public interface StorageService {
    CommonResult decrease(Long productId, Integer count);
}
