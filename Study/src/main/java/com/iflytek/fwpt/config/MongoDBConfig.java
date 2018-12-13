package com.iflytek.fwpt.config;

import com.mongodb.MongoClientOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MongoDBConfig {

    @Bean
    public MongoClientOptions mongoOptions() {
        return MongoClientOptions.builder().maxConnectionIdleTime(60000).build();
    }
}
