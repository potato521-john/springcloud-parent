package com.yht.springcloud.lib.impl;

import com.yht.springcloud.lib.Loadbalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements Loadbalancer {

    /**
     * 负载均衡算法:
     * 	rest接口第几次请求 % 服务器集群总数量 = 实际调用服务器的位置下标, 每一次服务器重启后rest接口计数从1开始
     *         List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("cloud-provider-payment-service");
     *
     * 	首先服务是放在list里面的
     * 	假设部署到两台机器,即服务器集群总数=2;
     * 	第一次请求:
     * 	1 % 2 = 1 返回 index = 1 list.get(index);
     * 	第二次请求:
     * 	2 % 2 =0 返回index = 0
     * list.get(idnex)
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current, next));
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
