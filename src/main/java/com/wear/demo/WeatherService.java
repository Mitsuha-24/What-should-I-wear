package com.wear.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;

@Service
public class WeatherService {
    private final RestClient restClient;
    private final String apiKey;
    
    // Simple In-Memory Cache: City Name -> WeatherResponse
    private final Map<String, WeatherResponse> cache = new ConcurrentHashMap<>();

    public WeatherService(RestClient.Builder builder, 
                          @Value("${weather.api.url}") String baseUrl, 
                          @Value("${weather.api.key}") String apiKey) {
        this.restClient = builder.baseUrl(baseUrl).build();
        this.apiKey = apiKey;
    }

    public WeatherResponse getWeatherData(String city) {
        // 1. Check Cache first
        if (cache.containsKey(city.toLowerCase())) {
            return cache.get(city.toLowerCase());
        }

        // 2. Cache miss? Call the API
        try {
            WeatherResponse response = restClient.get()
                .uri(uriBuilder -> uriBuilder
                    .queryParam("q", city)
                    .queryParam("appid", apiKey)
                    .queryParam("units", "metric")
                    .build())
                .retrieve()
                .body(WeatherResponse.class);

            // 3. Store in cache before returning
            cache.put(city.toLowerCase(), response);
            return response;
        } catch (HttpClientErrorException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Weather provider down");
        }
    }
}