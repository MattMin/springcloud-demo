package com.mzyupc.zkclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author mzyupc@163.com
 * @date 2019/11/12 10:56:54
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkUserApp {

    public static void main(String[] args) {
        SpringApplication.run(ZkUserApp.class, args);
    }

}
