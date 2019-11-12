## 使用Consul代替Eureka
本项目为客户端, 用于演示将客户端注册到Consul
- 作为消费者
- Consul使用 本地虚拟机(192.168.19.128)docker镜像
- Consul默认会调用http://ip:port/actuator/health检查服务健康信息, 所以maven要添加如下依赖
    ```$xslt
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
    ```