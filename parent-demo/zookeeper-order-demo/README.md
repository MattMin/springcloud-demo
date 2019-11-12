## 使用Zookeeper代替Eureka
- 作为消费者 使用Feign调用zk-user

本项目为客户端, 用于演示将客户端注册到Zookeeper

- zookeeper使用 本地虚拟机(192.168.19.128)docker镜像
```$xslt
docker pull zookeeper
docker run --name zk -d -p 2181:2181 --restart always zookeeper:latest
```