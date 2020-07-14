package com.jiuye.sona;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@Slf4j
@EnableConfigServer
@SpringBootApplication
public class SonaConfigServerApplication {

    /**
     * 启动配置中的服务端
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SonaConfigServerApplication.class, args);
        log.info("********* sona-config-server 启动成功 *********");
    }

}
