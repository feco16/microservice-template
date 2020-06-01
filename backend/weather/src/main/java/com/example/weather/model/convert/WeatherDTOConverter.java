package com.example.weather.model.convert;

import com.example.weather.model.DTO.WeatherDTO;
import com.example.weather.model.entity.Weather;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class WeatherDTOConverter implements Converter<Weather, WeatherDTO> {

    @Override
    public WeatherDTO convert(Weather source) {
        WeatherDTO weatherDTO = new WeatherDTO();
        weatherDTO.setUuid(source.getUuid());
        weatherDTO.setTemperature(source.getTemperature());
        weatherDTO.setPrecipitation(source.getPrecipitation());
        return weatherDTO;
    }
}
