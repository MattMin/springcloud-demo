package com.mzyupc.order.service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    Future<String> findUser(Integer id);

    /**
     * 查询所有用户
     *
     * @param ids
     * @return
     */
    List<String> findUserAll(List<Integer> ids);


}
