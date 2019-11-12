package csorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mzyupc@163.com
 * @date 2019/11/12 10:56:54
 */
@SpringBootApplication
// 如果注册中心使用consul/zookeeper, @EnableDiscoveryClient可以向注册中心注册服务
@EnableDiscoveryClient
@EnableFeignClients
public class CsOrderApp {

    public static void main(String[] args) {
        SpringApplication.run(CsOrderApp.class, args);
    }

}
