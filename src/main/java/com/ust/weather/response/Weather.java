package com.ust.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public record Weather(
        double latitude,
        double longitude,
//        double generationtime_ms,
//        int utc_offset_seconds,
        String timezone,
//        String timezone_abbreviation,
        double elevation,
//        CurrentUnits current_units,
        Current current
) {}

@JsonIgnoreProperties
record CurrentUnits(
        String time,
        String interval,
        String temperature_2m
) {}

@JsonIgnoreProperties
record Current(
        String time,
//        int interval,
        double temperature_2m
) {}
