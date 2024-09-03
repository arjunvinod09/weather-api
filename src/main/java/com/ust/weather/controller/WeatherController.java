package com.ust.weather.controller;

import com.ust.weather.response.Weather;
import com.ust.weather.service.ApiCallerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final ApiCallerService apiCallerService;

    @GetMapping("/fetch")
    public ResponseEntity<Weather> getWeather(@RequestParam("lat") double lat , @RequestParam("lon") double lon){
        return ResponseEntity.ok(apiCallerService.fetchWeather(lat,lon));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
