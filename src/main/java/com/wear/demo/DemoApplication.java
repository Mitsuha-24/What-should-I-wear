package com.wear.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // Add this method! It tells Spring: "If someone needs a RestClient.Builder, use this."
    @Bean
    public RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }
}