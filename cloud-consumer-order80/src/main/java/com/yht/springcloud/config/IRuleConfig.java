package com.yht.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 路由规则,可以自定义规则,此处简略
 */
@Configuration
public class IRuleConfig {
    /**
     * 自定义的路由算法:轮询,可以自己定义轮询算法,网上有
     * @return
     */
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
