package com.bcc.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ClassName:LoadBalancer
 * @Author:Andy-ge
 * @Date:2021/6/20 0:28
 */

public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
