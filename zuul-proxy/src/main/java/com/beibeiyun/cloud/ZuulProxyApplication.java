package com.beibeiyun.cloud;

import com.beibeiyun.Filter.PreLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableZuulProxy // 启用Zuul的API网关功能
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages =  "com.beibeiyun")
public class ZuulProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulProxyApplication.class, args);
    }
   /* @Bean
    public PreLogFilter preLogFilter() {
        return new PreLogFilter();
    }*/
}
