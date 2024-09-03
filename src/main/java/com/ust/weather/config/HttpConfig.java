package com.ust.weather.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Slf4j
@Configuration
public class HttpConfig {

    @Value("${api.base.url}")
    private String BASE_URL;

    @Bean
    public RestClient restClient() {
        log.info("BASE_URL: {}", BASE_URL);
        return RestClient.create(BASE_URL);
    }
}
