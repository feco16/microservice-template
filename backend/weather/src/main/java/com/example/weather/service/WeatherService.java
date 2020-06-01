package com.example.weather.service;

import com.example.weather.model.DTO.WeatherDTO;
import com.example.weather.model.convert.WeatherConverter;
import com.example.weather.model.convert.WeatherDTOConverter;
import com.example.weather.model.entity.Weather;
import com.example.weather.model.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;


@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private WeatherDTOConverter weatherDTOConverter;

    @Autowired
    private WeatherConverter weatherConverter;

    public List<WeatherDTO> getAllWeather() {
        List<Weather> list = (List<Weather>) weatherRepository.findAll();
        return list.stream()
                .map(weather -> weatherDTOConverter.convert(weather))
                .collect(toList());
    }

    public WeatherDTO getByUuid(String uuid) {
        return weatherDTOConverter.convert(weatherRepository.findByUuid(uuid));
    }

    public void createWeather(WeatherDTO weatherDTO) {
        weatherRepository.save(weatherConverter.convert(weatherDTO));
    }
}
