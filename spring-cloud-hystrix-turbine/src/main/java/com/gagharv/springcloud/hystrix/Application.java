package com.gagharv.springcloud.hystrix;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Created by wei.wang on 2018/8/13
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableTurbine
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
