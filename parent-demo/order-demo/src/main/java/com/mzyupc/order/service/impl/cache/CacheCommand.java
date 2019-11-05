package com.mzyupc.order.service.impl.cache;

import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.springframework.web.client.RestTemplate;

import static com.mzyupc.order.service.impl.OrderServiceImpl.GET_USER_URL;

/**
 * @author mzyupc@163.com
 * @date 2019/11/5 14:49:37
 *
 * hystrix 请求缓存
 */
public class CacheCommand extends HystrixCommand<String> {

    private Integer id;

    private RestTemplate restTemplate;

    private String cacheKey;

    public CacheCommand(Integer id, String cacheKey, RestTemplate restTemplate) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("cacheGroup")).andCommandKey(HystrixCommandKey.Factory.asKey("test")));
        this.id = id;
        this.restTemplate = restTemplate;
        this.cacheKey = cacheKey;
    }

    @Override
    protected String run() throws Exception {
        return restTemplate.getForObject(GET_USER_URL, String.class, id);
    }

    /**
     * 缓存的key
     *
     * @return 根据返回值判断是否为同一个请求
     */
    @Override
    protected String getCacheKey() {
        return cacheKey;
    }

    /**
     * 清空缓存
     */
    public void clearRequestCache(){
        HystrixRequestCache.getInstance(HystrixCommandKey.Factory.asKey("test"), HystrixConcurrencyStrategyDefault.getInstance())
                .clear(cacheKey);
    }
}
