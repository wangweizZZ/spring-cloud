package com.gagharv.springcloud.zuul.route;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wei.wang on 2018/7/17
 */
@ConfigurationProperties()
public class ConsulConfig {

    private List<ZuulRoute0> routes = new ArrayList<>();

    public void setRoutes(List<ZuulRoute0> routes) {
        this.routes = routes;
    }

    public List<ZuulRoute0> getRoutes() {
        return routes;
    }

}
