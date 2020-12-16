package com.jiuye.sona.eurake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class SonaEurakeApplication {

    private static final Logger logger = LoggerFactory.getLogger(SonaEurakeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SonaEurakeApplication.class, args);
        logger.info("***********sona-eurake 注册中心启动完毕*************");
    }

}
