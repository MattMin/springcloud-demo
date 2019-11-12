package com.mzyupc.zkorder.controller;

import com.mzyupc.zkorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mzyupc@163.com
 * @date 2019/11/12 11:15:21
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/user/{id}")
    public String getUserFromZkUser(@PathVariable String id){
        return orderService.getUserFromZkUser(id);
    }
}
