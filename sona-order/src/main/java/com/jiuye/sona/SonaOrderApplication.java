package com.jiuye.sona;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SonaOrderApplication {


    public static void main(String[] args) {
        SpringApplication.run(SonaOrderApplication.class, args);
        log.info("SONA-ORDER项目 启动完毕");
    }

}
