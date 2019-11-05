package com.mzyupc.order.service;

import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;

import java.util.concurrent.ExecutionException;

/**
 * @author mzyupc@163.com
 * @date 2019/11/4 13:46:33
 *
 * 使用RestTemplate进行远程调用
 */
public interface OrderService {

    String getUser(Integer id);

    String getUser2(String cacheKey, Integer id);

    String getUser3(String cacheKey, Integer id);

    void clearRequestCache(String cacheKey);

    String testPool() throws ExecutionException, InterruptedException;
}
