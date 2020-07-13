package com.yht.springcloud.web;

import com.yht.springcloud.service.StorageService;
import com.yht.springcloud.utils.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping(value = "/storage/decrease")
    @ResponseBody
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        return storageService.decrease(productId, count);
    }
}
