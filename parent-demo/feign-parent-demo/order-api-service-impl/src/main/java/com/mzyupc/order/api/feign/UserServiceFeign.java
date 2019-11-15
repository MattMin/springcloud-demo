package com.mzyupc.order.api.feign;

import com.mzyupc.user.api.service.UserService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author mzyupc@163.com
 * @date 2019/11/14 16:56:30
 */
@FeignClient("api-user-impl")
public interface UserServiceFeign extends UserService {
}
