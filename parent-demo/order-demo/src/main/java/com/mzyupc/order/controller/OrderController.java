package com.mzyupc.order.controller;

import com.mzyupc.order.service.OrderFeignService;
import com.mzyupc.order.service.OrderService;
import com.mzyupc.order.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mzyupc@163.com
 * @date 2019/11/4 13:42:17
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderFeignService feignService;

    /**
     * 使用RestTemplate调用生产者
     *
     * @param name
     * @param id
     * @return
     */
    @GetMapping("/newOrder")
    public String newOrder(String name, Integer id){
        String user = orderService.getUser(id);
        return "order: " + name + ", user: " +  user;
    }

    /**
     * 使用feign调用生产者
     *
     * @param name
     * @param id
     * @return
     */
    @GetMapping("/newOrder2")
    public String newOrder2(String name, Integer id){
        String user = feignService.getUser(id);
        return "order: " + name + ", user: " +  user;
    }

    @GetMapping("/getUser")
    public String getUser2(){
        UserVO userVO = new UserVO();
        userVO.setId(1);
        userVO.setName("小花");
        return feignService.getUser2(userVO);
    }
}
