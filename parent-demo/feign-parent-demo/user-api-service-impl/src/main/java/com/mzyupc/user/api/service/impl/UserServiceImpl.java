package com.mzyupc.user.api.service.impl;

import com.mzyupc.user.api.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author mzyupc@163.com
 * @date 2019/11/14 16:45:35
 */
@Service
public class UserServiceImpl implements UserService {
    @Value("${server.port}")
    private Integer port;

    @Override
    public String getUser(String id) {
        return id + " : " + port;
    }
}
