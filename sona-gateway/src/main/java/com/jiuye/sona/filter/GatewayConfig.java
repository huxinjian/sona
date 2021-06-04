package com.jiuye.sona.filter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xinjian.hu
 * @Date: 2021/6/2 18:32
 * @Email: huxinjian@jiuyescm.com
 */
@Configuration
public class GatewayConfig {

    /**
     * 注册过滤器
     *
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
            //可以使用通配符，例如：/provider/product/**
            .route("sona-order",
                r -> r.path("/order/createOrder")
                    .uri("lb://sona-order")
                    .filter(new MyGatewayFilter())
            ).build();
    }
}
