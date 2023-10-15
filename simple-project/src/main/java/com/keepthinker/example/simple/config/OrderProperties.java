package com.keepthinker.example.simple.config;

import org.springframework.boot.convert.DurationUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class OrderProperties {
    private String baseUrl;
    private String appKey;

    private Map<String, String> extra;

//    @DurationUnit(ChronoUnit.YEARS)// yaml里的单位优先级更高
    private Duration expireTime;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public Map<String, String> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, String> extra) {
        this.extra = extra;
    }

    public Duration getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Duration expireTime) {
        this.expireTime = expireTime;
    }
}
