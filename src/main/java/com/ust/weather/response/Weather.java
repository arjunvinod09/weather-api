package com.ust.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Weather(
//        double latitude,
//        double longitude,
//        double generationtime_ms,
//        int utc_offset_seconds,
//        String timezone,
//        String timezone_abbreviation,
//        double elevation,
//        CurrentUnits current_units,
        Current current
) {}