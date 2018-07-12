package com.gagharv.springcloud.service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wei.wang on 2018/7/6
 */
@RestController
public class DcController {
    @Autowired
    DiscoveryClient discoveryClient;

    @Value("${dc.aaa}")
    private String aa;

    @GetMapping("/")
    public String health() {
        System.out.println("Health");
        return "OK";
    }

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + aa;
        System.out.println(services);
        return services;
    }

}
