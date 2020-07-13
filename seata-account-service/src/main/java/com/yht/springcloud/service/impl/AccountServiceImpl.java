package com.yht.springcloud.service.impl;

import com.yht.springcloud.entities.TAccount;
import com.yht.springcloud.entities.TAccountExample;
import com.yht.springcloud.mapper.TAccountMapper;
import com.yht.springcloud.service.AccountService;
import com.yht.springcloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private TAccountMapper tAccountMapper;

    @Override
    public CommonResult decrease(Long userId, double money) {
        TAccountExample tAccountExample = new TAccountExample();
        TAccountExample.Criteria criteria = tAccountExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<TAccount> tAccounts = tAccountMapper.selectByExample(tAccountExample);
        if(CollectionUtils.isEmpty(tAccounts)){
            return new CommonResult(201, "未找到用户!");
        }
        tAccounts.get(tAccounts.size() - 1).setUsed(tAccounts.get(tAccounts.size() - 1).getUsed() + money);
        tAccounts.get(tAccounts.size() - 1).setResidue(tAccounts.get(tAccounts.size() - 1).getResidue() - money);
        TAccountExample example = new TAccountExample();
        TAccountExample.Criteria c = example.createCriteria();
        c.andUserIdEqualTo(tAccounts.get(tAccounts.size() - 1).getUserId());
        tAccountMapper.updateByExample(tAccounts.get(tAccounts.size() - 1), example);
        return new CommonResult(200, "成功!");
    }
}
