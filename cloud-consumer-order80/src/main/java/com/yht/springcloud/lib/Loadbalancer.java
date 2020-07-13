package com.yht.springcloud.lib;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface Loadbalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
