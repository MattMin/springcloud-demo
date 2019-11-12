package com.mzyupc.zkclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mzyupc@163.com
 * @date 2019/11/12 11:05:37
 */
@RestController
public class UserController {

    @Value("${server.port}")
    private String port;

    @GetMapping("user/{id}")
    public String getUser(@PathVariable String id){
        String user;
        switch (id) {
            case "1": user = "小花"; break;
            case "2": user = "老白"; break;
            case "3": user = "树梢"; break;
            case "4": user = "沐上"; break;
            default: user = "user not found!";
        }

        return user + " : " + port;
    }
}
