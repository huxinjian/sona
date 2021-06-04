package com.jiuye.sona.hystrix;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xinjian.hu
 * @Date: 2021/6/4 14:52
 * @Email: huxinjian@jiuyescm.com
 */
@RestController
public class DefaultHystrixController {

    @RequestMapping("/defaultFallback")
    public Map<String, String> defaultFallback() {
        Map<String, String> map = new HashMap<>();
        map.put("code", "500");
        map.put("msg", "服务降级");
        map.put("data", "null");
        return map;
    }
}
