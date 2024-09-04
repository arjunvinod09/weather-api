package com.ust.weather.response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Current(
//        String time,
//        int interval,
        double temperature_2m
) {}
