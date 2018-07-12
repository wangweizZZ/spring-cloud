package com.gagharv.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by wei.wang on 2018/7/11
 */
@SpringBootApplication
@EnableZuulProxy
@EnableCircuitBreaker
@EnableDiscoveryClient
public class Application  {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
