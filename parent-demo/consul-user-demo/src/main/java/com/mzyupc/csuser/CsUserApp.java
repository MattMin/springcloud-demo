package com.mzyupc.csuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author mzyupc@163.com
 * @date 2019/11/12 15:13:57
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CsUserApp {

    public static void main(String[] args) {
        SpringApplication.run(CsUserApp.class, args);
    }
}
