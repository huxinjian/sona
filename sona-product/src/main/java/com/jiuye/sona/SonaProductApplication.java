package com.jiuye.sona;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
public class SonaProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(SonaProductApplication.class, args);
        log.info("sona-product 启动成功");
    }
}
