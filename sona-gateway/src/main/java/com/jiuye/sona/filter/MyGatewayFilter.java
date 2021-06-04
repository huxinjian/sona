package com.jiuye.sona.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: xinjian.hu
 * @Date: 2021/6/2 18:28
 * @Email: huxinjian@jiuyescm.com
 */
public class MyGatewayFilter implements GatewayFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("==========自定义网关过滤器开始==========");
        System.out.println(exchange.getRequest().getPath());
        System.out.println(exchange.getRequest().getRemoteAddress());
        System.out.println("==========自定义网关过滤器结束==========");
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
