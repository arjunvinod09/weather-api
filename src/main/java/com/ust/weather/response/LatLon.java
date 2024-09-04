package com.ust.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public record LatLon (
        double lat,
        double lon,
        String country,
        String name
){}
