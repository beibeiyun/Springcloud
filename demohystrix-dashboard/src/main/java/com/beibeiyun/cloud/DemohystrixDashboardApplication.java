package com.beibeiyun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard   //启用监控功能
@EnableDiscoveryClient
@SpringBootApplication
public class DemohystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemohystrixDashboardApplication.class, args);
    }

}
