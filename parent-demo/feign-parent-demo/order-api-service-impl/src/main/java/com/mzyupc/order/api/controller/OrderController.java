package com.mzyupc.order.api.controller;

import com.mzyupc.order.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mzyupc@163.com
 * @date 2019/11/14 16:33:44
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("newOrder/{id}")
    public String newOrder(@PathVariable String id){
        return orderService.newOrder(id);
    }
}
