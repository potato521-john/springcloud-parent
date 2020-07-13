package com.yht.springcloud.service.impl;

import com.yht.springcloud.entities.TStorage;
import com.yht.springcloud.entities.TStorageExample;
import com.yht.springcloud.mapper.TStorageMapper;
import com.yht.springcloud.service.StorageService;
import com.yht.springcloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private TStorageMapper tStorageMapper;

    @Override
    public CommonResult decrease(Long productId, Integer count) {
        TStorageExample tStorageExample = new TStorageExample();
        TStorageExample.Criteria criteria = tStorageExample.createCriteria();
        criteria.andProductIdEqualTo(productId);
        List<TStorage> tStorage = tStorageMapper.selectByExample(tStorageExample);
        if(CollectionUtils.isEmpty(tStorage)){
            return new CommonResult(201, "商品为空!");
        }
        tStorage.get(tStorage.size() - 1).setUsed(tStorage.get(tStorage.size() - 1).getUsed() + count);
        tStorage.get(tStorage.size() - 1).setResidue(tStorage.get(tStorage.size() - 1).getResidue() - count);
        TStorageExample example = new TStorageExample();
        TStorageExample.Criteria c = example.createCriteria();
        c.andProductIdEqualTo(tStorage.get(tStorage.size() - 1).getProductId());
        tStorageMapper.updateByExampleSelective(tStorage.get(tStorage.size() - 1), example);
        return new CommonResult(200, "库减成功!");
    }
}
