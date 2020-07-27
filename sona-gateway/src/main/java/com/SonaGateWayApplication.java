package com;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class SonaGateWayApplication {

    /**
     * 服务网关
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SonaGateWayApplication.class, args);
        log.info("**********sona-gateway 启动成功************");
    }

}
