package com.ust.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CurrentUnits(
        String time,
        String interval,
        String temperature_2m
) {}
