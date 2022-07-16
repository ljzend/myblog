package com.ljz.myblog_admin.config.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : IgnoreUrlsConfig
 * @Description :
 * @Author : ljz
 * @Date: 2022/7/15  19:19
 */
@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlsConfig {
    private List<String> urls = new ArrayList<>();

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
