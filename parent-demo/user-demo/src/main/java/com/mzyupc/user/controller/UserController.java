package com.mzyupc.user.controller;

import com.mzyupc.user.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mzyupc@163.com
 * @date 2019/11/4 11:34:57
 */
@Api("用户接口")
@RestController
public class UserController {

    @Value("${server.port}")
    private Integer port;

    @ApiOperation(value = "根据用户id查询用户名", response = String.class)
    @GetMapping("/user/{id}")
    public String getUser(@ApiParam(required = true) @PathVariable("id") Integer id){
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

    @GetMapping("/userAll")
    public List<String> getUsedAll(@RequestParam List<Integer> ids){
        List users = new ArrayList();
        for (Integer id : ids) {
            users.add("用户: " + id);
        }

        return users;
    }
}
