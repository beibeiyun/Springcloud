package com.beibeiyun.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
    @Bean
    @LoadBalanced    //赋予RestTemplate负载均衡功能
    public RestTemplate restTemplate(){
       return new RestTemplate();
    }
}
