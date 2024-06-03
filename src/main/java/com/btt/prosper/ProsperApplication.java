package com.btt.prosper;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ProsperApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProsperApplication.class, args);
        log.info("server 启动");
    }

}
