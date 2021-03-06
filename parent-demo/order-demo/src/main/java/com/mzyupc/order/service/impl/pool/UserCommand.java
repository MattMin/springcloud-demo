package com.mzyupc.order.service.impl.pool;

import com.netflix.hystrix.*;

/**
 * @author mzyupc@163.com
 * @date 2019/11/5 13:56:09
 *
 * 对业务类的包装, 实现依赖隔离, run()方法中实现业务逻辑
 */
public class UserCommand extends HystrixCommand<String> {

    private String value;

    public UserCommand(String value) {
        super(Setter.withGroupKey(
                // 服务分组
                HystrixCommandGroupKey.Factory.asKey("UserGroup"))
                // 线程分组
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("UserPool"))
                // 线程池设置
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withCoreSize(10)
                        .withKeepAliveTimeMinutes(5)
                        .withMaxQueueSize(10)
                        .withQueueSizeRejectionThreshold(10000))
                // 线程池隔离方式
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                )
        );
        this.value = value;
    }

    @Override
    protected String run() throws Exception {
        String name = Thread.currentThread().getName();
        String result = String.format("UserCommand, thread name: %s, value: %s", name, value);
        System.out.println(result);
        return result;
    }
}
