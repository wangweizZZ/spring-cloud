package com.gagharv.springcloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;

/**
 * Created by wei.wang on 2018/7/12
 */
@SpringBootApplication
@EnableZipkinServer
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
