package com.jiuye.sona.hystrix;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xinjian.hu
 * @Date: 2020/7/20 14:12
 * @Email: huxinjian@jiuyescm.com
 */

@RestController
public class ProductFallbackController {

    /**
     * product的回退
     *
     * @return
     */
    @GetMapping("/productFallback")
    public String fallBack(){
        return "用户过多,稍后重试";
    }
}
