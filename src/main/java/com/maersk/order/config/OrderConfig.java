package com.maersk.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan({"com.maersk.order"})
@EnableReactiveCassandraRepositories
public class OrderConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
