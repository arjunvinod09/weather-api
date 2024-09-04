package com.ust.weather.controller;

import com.ust.weather.response.LatLon;
import com.ust.weather.response.ResponseDto;
import com.ust.weather.response.Weather;
import com.ust.weather.service.ApiCallerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final ApiCallerService apiCallerService;

    @GetMapping("/fetch")
    public ResponseEntity<ResponseDto> getWeather(@RequestParam("zip") String zip , @RequestParam("country") String country) {
        log.info("Fetching weather for {} and {}", zip, country);
        LatLon latLon = apiCallerService.fetchLatLon(zip, country);
        List<Double> latLong = List.of(latLon.lat(),latLon.lon());
        var weather = new Weather(apiCallerService.fetchWeather(latLong.get(0),latLong.get(1)).current());
        log.info("Fetched weather {} and geo api result {} ", weather , latLon);
        return ResponseEntity.ok(new ResponseDto(latLon.name(),latLon.country(),weather.current().temperature_2m()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
