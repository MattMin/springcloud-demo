package com.mzyupc.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author mzyupc@163.com
 * @date 2019/11/6 10:49:03
 */
@SpringBootApplication
// 开启zuul功能
@EnableZuulProxy
@EnableEurekaClient
// 开启swagger
@EnableSwagger2
public class ZuulApp {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApp.class, args);
    }
}
