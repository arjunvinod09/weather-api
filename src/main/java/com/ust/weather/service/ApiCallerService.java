package com.ust.weather.service;

import com.ust.weather.response.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class ApiCallerService {

    private final RestClient restClient;

    public Weather fetchWeather(double lat , double lon){
        return restClient.get()
                .uri("/forecast?latitude={lat}&longitude={lon}&current=temperature_2m" , lat , lon)
                .retrieve()
                .body(Weather.class);
    }
}
