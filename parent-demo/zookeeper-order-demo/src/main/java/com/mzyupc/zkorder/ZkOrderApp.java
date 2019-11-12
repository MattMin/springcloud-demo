package com.mzyupc.zkorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mzyupc@163.com
 * @date 2019/11/12 10:56:54
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ZkOrderApp {

    public static void main(String[] args) {
        SpringApplication.run(ZkOrderApp.class, args);
    }

}
