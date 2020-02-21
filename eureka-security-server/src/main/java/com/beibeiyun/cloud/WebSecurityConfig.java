package com.beibeiyun.cloud;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity){

        try {
            httpSecurity.csrf().ignoringAntMatchers("/eureka/**");
            super.configure(httpSecurity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
