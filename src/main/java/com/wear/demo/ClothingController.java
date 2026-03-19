package com.wear.demo;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClothingController {

    private final WeatherService weatherService;
    private final wearing recommendationService;

    // This is perfect - Constructor injection is the gold standard!
    public ClothingController(WeatherService weatherService, wearing recommendationService) {
        this.weatherService = weatherService;
        this.recommendationService = recommendationService;
    }
    
    @GetMapping("/recommend")
    public Map<String, Object> getWhatToWear(@RequestParam String city) {
        // 1. Fetch data from OpenWeather
        WeatherResponse data = weatherService.getWeatherData(city);

        // 2. Get recommendation based on temp and condition
        // Note: Using .get(0) is fine, but assumes the API always returns at least one weather condition
        if(city.isEmpty()){
            return Map.of("error","city not found");
        }
        String advice = recommendationService.WearCloth(
            data.main().temp(), 
            data.weather().get(0).description()
        );

        // 3. Return the response
        // I changed the Map type to <String, Object> because temp is a double and others are Strings
        return Map.of(
            "city", city,
            "temperature", data.main().temp() + "°C",
            "condition", data.weather().get(0).description(),
            "recommendation", advice
        );
    }
}