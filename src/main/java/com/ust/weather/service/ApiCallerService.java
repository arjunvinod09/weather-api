package com.ust.weather.service;

import com.ust.weather.response.LatLon;
import com.ust.weather.response.Weather;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiCallerService {

    private final RestClient restClient;
    private final RestClient geoConfigClient;

    @Value("${api.geo.config.key}")
    private String api_key;

    public Weather fetchWeather(double lat , double lon){
        return restClient.get()
                .uri("/forecast?latitude={lat}&longitude={lon}&current=temperature_2m" , lat , lon)
                .retrieve()
                .body(Weather.class);
    }

    public LatLon fetchLatLon(String zip, String country) {
        log.info("Fetching lat/lon from {} {} using url http://api.openweathermap.org/geo/1.0/zip?zip={},{}&appid={}" , zip, country, zip, country, api_key);
        return geoConfigClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/zip")
                        .queryParam("zip", "{zip},{country}")
                        .queryParam("appid", "{api_key}")
                        .build(zip, country, api_key))
                .retrieve()
                .body(LatLon.class);
    }
}
