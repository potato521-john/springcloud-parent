package com.yht.springcloud.service;

import com.yht.springcloud.utils.CommonResult;

public interface AccountService {
    CommonResult decrease(Long userId, double money);
}
