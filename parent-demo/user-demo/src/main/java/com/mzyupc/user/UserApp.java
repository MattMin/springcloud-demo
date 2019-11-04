package com.mzyupc.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author mzyupc@163.com
 * @date 2019/11/4 11:32:20
 */
@SpringBootApplication
@EnableEurekaClient
public class UserApp {
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class, args);
    }
}
