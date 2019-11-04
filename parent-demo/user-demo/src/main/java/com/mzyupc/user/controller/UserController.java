package com.mzyupc.user.controller;

import com.mzyupc.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author mzyupc@163.com
 * @date 2019/11/4 11:34:57
 */
@RestController
public class UserController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Integer id){
        String result;
        switch (id){
            case 1: result = "一点点";
            break;
            case 2: result = "乐乐";
            break;
            default: result = "user not found!";
        }

        return String.format("%s 端口: %s", result, port);
    }

    @PostMapping("/user2")
    public String getUser2(@RequestBody UserVO user){
        return "ok! " + user;
    }
}
