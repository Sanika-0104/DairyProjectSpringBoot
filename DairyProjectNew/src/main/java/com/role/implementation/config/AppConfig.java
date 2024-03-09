package com.role.implementation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.role.implementation.model.Admin;

@Configuration
public class AppConfig {

    @Bean
    public Admin admin() {
        return new Admin();
    }
}
