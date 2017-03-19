package com.hello.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by ligaozhao on 19/03/17.
 */
@Configuration
public class UserServiceImpl {

    @Value("${host}")
    private String Host;

    @Bean
    public DataSource test() {
        System.out.println(this.Host);
        return null;
    }
}
