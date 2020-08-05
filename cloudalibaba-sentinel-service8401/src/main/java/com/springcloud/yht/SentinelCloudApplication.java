package com.springcloud.yht;

import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.springcloud.yht.config.MyRuleConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelCloudApplication {
    
    public static void main(String[] args) {
//        initFlowRules();
        SpringApplication.run(SentinelCloudApplication.class,args);
    }

    private static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("me");
        rule.setGrade(MyRuleConstant.FLOW_GRADE_QPS);
        //set qps to 5
        rule.setCount(5);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
