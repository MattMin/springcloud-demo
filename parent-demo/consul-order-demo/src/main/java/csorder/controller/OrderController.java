package csorder.controller;

import csorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author mzyupc@163.com
 * @date 2019/11/12 11:15:21
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/user/{id}")
    public String getUserFromZkUser(@PathVariable String id){
        return orderService.getUserFromZkUser(id);
    }

    /**
     * 利用DiscoveryClient获取所有注册的服务
     *
     * 可用于自定义负载均衡策略
     *
     * @param serviceId
     * @return
     */
    @GetMapping("/client/{serviceId}")
    public String getClient(@PathVariable String serviceId){
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        return instances.toString();
    }
}
