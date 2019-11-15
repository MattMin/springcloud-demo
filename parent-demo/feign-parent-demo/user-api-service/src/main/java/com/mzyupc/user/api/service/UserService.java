package com.mzyupc.user.api.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mzyupc@163.com
 * @date 2019/11/14 16:41:51
 */
public interface UserService {
    @GetMapping("/user/{id}")
    String getUser(@PathVariable String id);
}
