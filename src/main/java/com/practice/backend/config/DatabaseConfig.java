package com.practice.backend.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Autowired
    private Environment env;

    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .url("jdbc:mysql://127.0.0.1:3306/pet_nursery?useSSL=false&allowPublicKeyRetrieval=true")
                .username("pet_nursery")
                .password("kPy7JkkzlRBldBv5x3dvlEH9YqMSEIfvvSc1oOnS")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
