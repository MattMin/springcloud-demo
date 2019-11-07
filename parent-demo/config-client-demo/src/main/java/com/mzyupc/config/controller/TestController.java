package com.mzyupc.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mzyupc@163.com
 * @date 2019/11/6 16:28:34
 */
@RestController
// 开启配置文件更新功能
@RefreshScope
public class TestController {

    @Value("${email}")
    private String email;

    @GetMapping("/email")
    public String getEmail(){
        return email;
    }
}
