package com.jiuye.sona;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableEurekaClient
@EnableHystrix
public class SonaOrderApplication {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SonaOrderApplication.class, args);
        log.info("SONA-ORDER项目 启动完毕");
    }

}
