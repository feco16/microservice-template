package com.example.weather.model.convert;

import com.example.weather.model.DTO.WeatherDTO;
import com.example.weather.model.entity.Weather;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class
WeatherConverter implements Converter<WeatherDTO, Weather> {

    @Override
    public Weather convert(WeatherDTO source) {
        Weather weather = new Weather();
        weather.setUuid(source.getUuid());
        weather.setTemperature(source.getTemperature());
        weather.setPrecipitation(source.getPrecipitation());
        return weather;
    }
}
