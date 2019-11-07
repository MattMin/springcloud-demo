# spring-cloud demo项目
## 项目结构
- parent-demo  父项目, 用于组织管理下面的子项目
    - eureka-demo  服务中心
    - user-demo  客户端(生产者)
    - order-demo 客户端(消费者), ribbon/feign/hystrix 演示代码
    - config-client-demo 分布式配置客户端演示代码
    - config-server-demo 分布式配置中心
    - zuul-demo 路由网关
- config 分布式配置文件存放路径, 供config-server-demo扫描

## 涵盖内容
1. Eureka服务注册与发现
2. 生产者(user-demo),消费者(order-demo)调用演示
3. Ribbon负载均衡
4. Feign接口调用
5. Hystrix 请求熔断/服务降级/依赖隔离/请求缓存
6. Spring-Cloud-Config分布式配置中心以及其集群操作
7. Zuul 路由网关
8. Zuul 整合Swagger使用

## 依赖服务
- rabbitmq
    - 使用rabbitmq:management docker镜像
    ```
  # 拉取镜像
  docker pull rabbitmq:management
  # 启动镜像, 15672为管理平台端口, 5672为服务端口
  # 默认用户名:密码 guest:guest
  docker run -d --hostname my-rabbit --name rabbit -p 15672:15672 -p 5672:5672 rabbitmq:management
  ```
