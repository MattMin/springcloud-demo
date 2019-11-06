package com.mzyupc.order.service.impl.fallback;

import com.mzyupc.order.service.OrderFeignService;
import com.mzyupc.order.vo.UserVO;
import org.springframework.stereotype.Service;

/**
 * @author mzyupc@163.com
 * @date 2019/11/5 10:10:46
 *
 * 通过feign接口远程调用的fallback方法
 */
@Service
public class OrderFeignFallBackServiceImpl implements OrderFeignService {
    @Override
    public String getUser(Integer id) {
        return "user not found ";
    }

    @Override
    public String getUser2(UserVO user) {
        return "user not found 2";
    }
}
