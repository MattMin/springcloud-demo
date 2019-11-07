package com.mzyupc.zuul.config;

import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mzyupc@163.com
 * @date 2019/11/7 15:24:03
 */
@Component
@Primary
public class SwaggerConfig implements SwaggerResourcesProvider {
    private final RouteLocator routeLocator;

    public SwaggerConfig(RouteLocator routeLocator){
        this.routeLocator = routeLocator;
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> result = new ArrayList<>();
        // location: {zuul.routes.route-name.path | serviceId}/{context-ath}/v2/api-docs
        result.add(swaggerResource("订单系统", "/api-order/order/v2/api-docs", "1.0"));
        result.add(swaggerResource("用户系统", "/api-user/user/v2/api-docs", "1.0"));
        return result;
    }

    private SwaggerResource swaggerResource(String name, String location, String version){
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
