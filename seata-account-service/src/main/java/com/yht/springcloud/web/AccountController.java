package com.yht.springcloud.web;

import com.yht.springcloud.service.AccountService;
import com.yht.springcloud.utils.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping(value = "/account/decrease")
    @ResponseBody
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") double money){
        accountService.decrease(userId, money);
        return new CommonResult(200, "成功");
    }
}
