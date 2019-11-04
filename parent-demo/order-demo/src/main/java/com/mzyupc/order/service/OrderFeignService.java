package com.mzyupc.order.service;

import com.mzyupc.order.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author mzyupc@163.com
 * @date 2019/11/4 15:11:53
 *
 * 使用feign进行远程调用
 */
@FeignClient(value = "user-client")
public interface OrderFeignService {

    @GetMapping(value = "/user/user/{id}")
    String getUser(@PathVariable("id") Integer id);

    @PostMapping(value = "/user/user2")
    String getUser2(UserVO user);
}
