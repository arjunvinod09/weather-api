package com.ust.weather.response;

public record ResponseDto(
        String city,
        String country,
        double temperature
) {
}
