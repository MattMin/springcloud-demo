package com.mzyupc.order.controller;

import com.mzyupc.order.service.OrderFeignService;
import com.mzyupc.order.service.OrderService;
import com.mzyupc.order.vo.UserVO;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author mzyupc@163.com
 * @date 2019/11/4 13:42:17
 */
@Api("订单接口")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderFeignService feignService;

    /**
     * 使用RestTemplate调用生产者
     *
     * @param name
     * @param id
     * @return
     */
    @ApiOperation(value = "新建订单", response = String.class)
    @GetMapping("/newOrder")
    public String newOrder(String name, Integer id){
        String user = orderService.getUser(id);
        return "order: " + name + ", user: " +  user;
    }

    @GetMapping("/getUserCache")
    public String getUserCache(){
        // Hystrix请求上下文, 在一个上下文中缓存有效
        HystrixRequestContext context = HystrixRequestContext.initializeContext();

        String user1 = orderService.getUser2("cacheKey", 1);
        String user2 = orderService.getUser2("cacheKey", 2);

        context.close();
        return String.format("user1: %s; user2: %s", user1, user2);
    }

    @GetMapping("/getUserCache2")
    public String getUserCache2(){
        String cacheKey = "cacheKey";
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String user1 = orderService.getUser3(cacheKey, 1);
        // 清除缓存
//        orderService.clearRequestCache(cacheKey);
        String user2 = orderService.getUser3(cacheKey, 2);
        context.close();
        return String.format("user1: %s; user2: %s", user1, user2);
    }

    /**
     * 使用feign调用生产者
     *
     * @param name
     * @param id
     * @return
     */
    @GetMapping("/newOrder2")
    public String newOrder2(String name, Integer id){
        String user = feignService.getUser(id);
        return "order: " + name + ", user: " +  user;
    }

    @GetMapping("/getUser")
    public String getUser2(){
        UserVO userVO = new UserVO();
        userVO.setId(1);
        userVO.setName("小花");
        return feignService.getUser2(userVO);
    }

    @GetMapping("/pool")
    public String pool() throws ExecutionException, InterruptedException {
        return orderService.testPool();
    }

    @GetMapping("/requestMerge")
    public String requestMerge() throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();

        Future<String> one = orderService.findUser(1);
        Future<String> one1 = orderService.findUser(2);
        Future<String> one2 = orderService.findUser(3);
        String format = String.format("one: %s, one1: %s, one2: %s", one.get(), one1.get(), one2.get());

        context.close();
        return format;
    }

}
