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
        /*Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            new Thread(() -> {
                for (int i = 0; i < 150; i++) {
                    try {
                        byte[] temp = new byte[1024 * 1024];
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }, 100, 100, TimeUnit.MICROSECONDS);*/
    }

}
