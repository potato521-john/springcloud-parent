package com.yht.springcloud.service.impl;

import com.yht.springcloud.common.CommonResult;
import com.yht.springcloud.entities.Payment;
import com.yht.springcloud.mapper.PaymentMapper;
import com.yht.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        CommonResult result = new CommonResult();
        if(id == null){
            return result.setMsg("id不能为空!").setCode(201).setData(null);
        }else {
            Payment payment = paymentMapper.selectByPrimaryKey(id);
            return result.setData(payment).setCode(200).setMsg("查询成功!");
        }
    }

    @Override
    public CommonResult<Payment> create(Payment payment) {
        CommonResult result = new CommonResult();
       if(ObjectUtils.isEmpty(payment)){
           return new CommonResult(201, "插入数据库失败!");
       }
        int resultNum = paymentMapper.insertSelective(payment);
       if(resultNum > 0){
           result.setData(resultNum);
       }else {
           return new CommonResult(201, "插入数据失败!");
       }
       result.setCode(200);
       result.setMsg("插入数据库数据成功!");
        return result;
    }
}
