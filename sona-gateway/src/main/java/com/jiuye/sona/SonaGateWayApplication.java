package com.jiuye.sona;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
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
