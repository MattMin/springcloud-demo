package com.mzyupc.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mzyupc@163.com
 * @date 2019/11/14 16:30:07
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderImplApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderImplApp.class, args);
    }
}
