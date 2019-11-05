package com.mzyupc.order.service;

import java.util.concurrent.ExecutionException;

/**
 * @author mzyupc@163.com
 * @date 2019/11/4 13:46:33
 *
 * 使用RestTemplate进行远程调用
 */
public interface OrderService {

    String getUser(Integer id);

    String testPool() throws ExecutionException, InterruptedException;
}
