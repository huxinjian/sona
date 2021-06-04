package com.jiuye.sona.filter.global;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: xinjian.hu
 * @Date: 2021/6/4 14:06
 * @Email: huxinjian@jiuyescm.com
 */
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {

    /**
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("==========自定义全局过滤器开始==========");
        System.out.println(exchange.getRequest().getPath());
        System.out.println("==========自定义全局过滤器结束==========");
        return chain.filter(exchange);
    }

    /**
     * 过滤器链执行顺序，数值越小，执行顺序越靠前
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
