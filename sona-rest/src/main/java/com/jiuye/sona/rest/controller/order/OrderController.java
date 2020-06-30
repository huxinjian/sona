package com.jiuye.sona.rest.controller.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xinjian.hu
 * @Date: 2020/6/23 15:59
 * @Email: huxinjian@jiuyescm.com
 */
@RequestMapping("/order")
@RestController
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(OrderController.class);
    /**
     * 根据id获取订单
     *
     * @param personId
     */
    @GetMapping("/queryOrder")
    public Map<String, Object> queryOrder(String personId) {
        Map map  = new HashMap();

        if ("001".equals(personId)) {
            map.put("orderNo", "1234");
            map.put("recevicePhone", "13111112222");
            map.put("recevicePerson", "123123");
            return map;
        }
        return map;

    }
}
