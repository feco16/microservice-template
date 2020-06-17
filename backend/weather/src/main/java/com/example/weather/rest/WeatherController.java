package com.example.weather.rest;

import com.example.weather.model.DTO.WeatherDTO;
import com.example.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping
    public List<WeatherDTO> getAllWeather() {
       return weatherService.getAllWeather();
    }

    @GetMapping("/{uuid}")
    public WeatherDTO getByUuid(@PathVariable String uuid){
        return weatherService.getByUuid(uuid);
    }

    @PostMapping
    public void postWeather(WeatherDTO weatherDTO) {
        weatherService.createWeather(weatherDTO);
    }
}
