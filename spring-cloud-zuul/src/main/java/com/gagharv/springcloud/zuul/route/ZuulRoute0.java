package com.gagharv.springcloud.zuul.route;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by wei.wang on 2018/7/17
 */
public class ZuulRoute0 {

    private String id;

    private String path;

    private String serviceId;

    private String url;

    private boolean stripPrefix = true;

    private Boolean retryable;

    private Set<String> sensitiveHeaders = new LinkedHashSet<>();

    private boolean customSensitiveHeaders = false;

    public void setId(String id) {
        this.id = id;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setStripPrefix(boolean stripPrefix) {
        this.stripPrefix = stripPrefix;
    }

    public void setRetryable(Boolean retryable) {
        this.retryable = retryable;
    }

    public void setSensitiveHeaders(Set<String> sensitiveHeaders) {
        this.sensitiveHeaders = sensitiveHeaders;
    }

    public void setCustomSensitiveHeaders(boolean customSensitiveHeaders) {
        this.customSensitiveHeaders = customSensitiveHeaders;
    }

    public String getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getUrl() {
        return url;
    }

    public boolean isStripPrefix() {
        return stripPrefix;
    }

    public Boolean getRetryable() {
        return retryable;
    }

    public Set<String> getSensitiveHeaders() {
        return sensitiveHeaders;
    }

    public boolean isCustomSensitiveHeaders() {
        return customSensitiveHeaders;
    }
}
