package com.jiuye.sona.limiter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @Author: xinjian.hu
 * @Date: 2021/6/4 15:25
 * @Email: huxinjian@jiuyescm.com
 */
@Configuration
public class GatewayConfig {

    /**
     * 如果你想要根据用户的ip地址来限流，请打开这个@Bean注解，三种方式不能同时存在
     * application.yaml请配置，key-resolver: '#{@ipKeyResolver}'
     */
    //@Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }

    /**
     * 如果你想要根据用户的名称来限流，请打开这个@Bean注解，但是，请求地址一定要包含userId这个参数，三种方式不能同时存在
     * application.yaml请配置，key-resolver: '#{@userKeyResolver}'
     * 注意：此种方式并不是一定是userId，你可以指定任意参数名称，前提是你的请求中一定要包含该参数，所以这种方法又叫做根据请求参数限流
     */
    //@Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
    }

    /**
     * 如果你想要根据用户的请求地址来限流，请打开这个@Bean注解，三种方式不能同时存在
     * application.yaml请配置，key-resolver: '#{@pathKeyResolver}'
     */
    @Bean
    KeyResolver pathKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }
}
