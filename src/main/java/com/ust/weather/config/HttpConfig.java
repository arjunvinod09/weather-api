package com.ust.weather.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class HttpConfig {

    @Value("${api.base.url}")
    private String BASE_URL;
    @Value("${api.geo.config.base.url}")
    private String base_URL;

    @Bean
    public RestClient restClient() {
        return RestClient.create(BASE_URL);
    }

    @Bean
    public RestClient geoConfigClient(){
        return RestClient.create(base_URL);
    }
}
