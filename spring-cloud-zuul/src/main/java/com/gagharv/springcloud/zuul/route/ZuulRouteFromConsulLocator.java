package com.gagharv.springcloud.zuul.route;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.DiscoveryClientRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.discovery.ServiceRouteMapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wei.wang on 2018/7/17
 */

public class ZuulRouteFromConsulLocator {
    //extends SimpleRouteLocator implements RefreshableRouteLocator
    private static final Log log = LogFactory.getLog(DiscoveryClientRouteLocator.class);

    public static final String DEFAULT_ROUTE = "/**";

    private DiscoveryClient discovery;

    private ZuulProperties properties;

    private ServiceRouteMapper serviceRouteMapper;

    private ConsulConfig consulConfig;


    protected Map<String, ZuulProperties.ZuulRoute> locateRoutesFromConsul() {
        Map<String, ZuulProperties.ZuulRoute> routes = new LinkedHashMap<>();
        List<ZuulRoute0> results = consulConfig.getRoutes();
        for (ZuulRoute0 result : results) {
            if (org.apache.commons.lang3.StringUtils.isBlank(result.getPath()) || org.apache.commons.lang3.StringUtils.isBlank(result.getServiceId())) {
                continue;
            }
            ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
            try {
                org.springframework.beans.BeanUtils.copyProperties(result, zuulRoute);
            } catch (Exception e) {
                log.error("=============load zuul route info from db with error==============", e);
            }
            routes.put(zuulRoute.getPath(), zuulRoute);
        }
        return routes;
    }
}
