package com.mzyupc.order.service.impl;

import com.mzyupc.order.service.OrderService;
import com.mzyupc.order.service.impl.cache.CacheCommand;
import com.mzyupc.order.service.impl.pool.OrderCommand;
import com.mzyupc.order.service.impl.pool.UserCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author mzyupc@163.com
 * @date 2019/11/4 13:47:16
 *
 * 使用RestTemplate进行远程调用
 */
@Service
public class OrderServiceImpl implements OrderService {
    public static final String GET_USER_URL = "http://user-client/user/user/{id}";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    // 指定降级方法
    @HystrixCommand(fallbackMethod = "getUserFallBack")
    public String getUser(Integer id) {
        return restTemplate.getForObject(GET_USER_URL, String.class, id);
    }

    /**
     * hystrix 请求缓存 基于继承HystrixCommand的方式
     *
     * @param cacheKey
     * @param id
     * @return
     */
    @Override
    public String getUser2(String cacheKey, Integer id) {
        CacheCommand cacheCommand = new CacheCommand(id, cacheKey, restTemplate);
        String result = cacheCommand.execute();
        // 清空缓存
//        cacheCommand.clearRequestCache();
        return result;
    }

    /**
     *  hystrix 请求缓存 基于注解的方式
     *
     * @param cacheKey
     * @param id
     * @return
     */
    @Override
    @CacheResult
    @HystrixCommand(commandKey = "cache-user")
    public String getUser3(@CacheKey String cacheKey, Integer id) {
        return restTemplate.getForObject(GET_USER_URL, String.class, id);
    }

    @Override
    @CacheRemove(commandKey = "cache-user")
    @HystrixCommand
    public void clearRequestCache(@CacheKey String cacheKey){
    }

    /**
     * hystrix getUser() 服务降级方法
     *
     * 要与getUser()参数/返回值类型相同
     *
     * @return
     */
    public String getUserFallBack(Integer id){
        return "user not found RestTemplate";
    }

    /**
     * 测试依赖隔离(线程池隔离)
     *
     * @return
     */
    @Override
    public String testPool() throws ExecutionException, InterruptedException {
        UserCommand userCommand = new UserCommand("小花");
        UserCommand userCommand1 = new UserCommand("小花1");

        OrderCommand orderCommand1 = new OrderCommand("老白");
        OrderCommand orderCommand2 = new OrderCommand("树梢");

        // 同步调用
        String value1 = userCommand.execute();
        String value2 = orderCommand1.execute();
        String value3 = orderCommand2.execute();

        // 异步调用
        Future<String> queue = userCommand1.queue();

        return String.format("同步调用结果: %s; %s; %s. 异步调用结果: %s", value1, value2, value3, queue.get());
    }
}
