package com.mzyupc.order.api.service;

import com.mzyupc.order.api.feign.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mzyupc@163.com
 * @date 2019/11/14 16:32:50
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Override
    public String newOrder(String userId) {
        return userServiceFeign.getUser(userId);
    }
}
