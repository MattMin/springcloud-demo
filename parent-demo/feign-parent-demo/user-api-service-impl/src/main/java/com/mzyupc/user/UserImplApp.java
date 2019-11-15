package com.mzyupc.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author mzyupc@163.com
 * @date 2019/11/14 16:44:38
 */
@SpringBootApplication
@EnableEurekaClient
public class UserImplApp {
    public static void main(String[] args) {
        SpringApplication.run(UserImplApp.class, args);
    }
}
