package com.wear.demo;

import java.util.List;

public record WeatherResponse(
    List<Weather> weather,
    MainData main
) {}

record Weather(String description) {}

record MainData(double temp, int humidity) {}