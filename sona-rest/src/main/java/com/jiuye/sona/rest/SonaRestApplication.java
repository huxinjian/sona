package com.jiuye.sona.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SonaRestApplication {

    private static final Logger logger = LoggerFactory.getLogger(SonaRestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SonaRestApplication.class, args);
        logger.info("SONA-REST项目 启动完毕");
    }

}
