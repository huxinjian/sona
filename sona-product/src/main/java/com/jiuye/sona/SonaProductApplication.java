package com.jiuye.sona;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@MapperScan(basePackages = "com.jiuye.sona.product.dao")
public class SonaProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(SonaProductApplication.class, args);
        log.info("***********sona-product 启动成功*************");
    }
}
