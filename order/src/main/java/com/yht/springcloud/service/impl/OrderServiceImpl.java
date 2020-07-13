package com.yht.springcloud.service.impl;

import com.yht.springcloud.entities.TOrder;
import com.yht.springcloud.entities.TOrderExample;
import com.yht.springcloud.mapper.TOrderMapper;
import com.yht.springcloud.service.AccountService;
import com.yht.springcloud.service.OrderService;
import com.yht.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private TOrderMapper tOrderMapper;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "yht_tx_group", rollbackFor = Exception.class)
    public void create(TOrder order) {
        if(ObjectUtils.isEmpty(order)){
            log.info("订单不能为空");
            return;
        }
        log.info("开始创建订单!");
        tOrderMapper.insert(order);

        log.info("创建订单成功,开始调用库存,做库减.");
        storageService.decrease(order.getProductId(), order.getCount());

        log.info("库减成功,账户金额减少!");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("账户金额创建成功!");

        //修改订单的状态:1:正常;0;异常
        TOrderExample tOrderExample = new TOrderExample();
        TOrderExample.Criteria criteria = tOrderExample.createCriteria();
        criteria.andProductIdEqualTo(order.getProductId());
        criteria.andProductIdEqualTo(order.getUserId());
        order.setStatus(1);
        tOrderMapper.updateByExampleSelective(order,tOrderExample);
        log.info("成功!");
    }
}
