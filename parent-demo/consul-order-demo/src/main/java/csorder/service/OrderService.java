package csorder.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mzyupc@163.com
 * @date 2019/11/12 11:11:59
 */

// value=serviceId, path=contextPath + controllerPath
@FeignClient(value = "cs-user")
public interface OrderService {

    @GetMapping(value = "/user/{id}")
    String getUserFromZkUser(@PathVariable String id);

}
