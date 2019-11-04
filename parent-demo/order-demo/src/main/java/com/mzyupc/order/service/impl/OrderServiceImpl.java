package com.mzyupc.order.service.impl;

import com.mzyupc.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author mzyupc@163.com
 * @date 2019/11/4 13:47:16
 *
 * 使用RestTemplate进行远程调用
 */
@Service
public class OrderServiceImpl implements OrderService {
    private static final String GET_USER_URL = "http://user-client/user/user/{id}";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getUser(Integer id) {
        return restTemplate.getForObject(GET_USER_URL, String.class, id);
    }
}
