package com.example.weather.model.repository;

import com.example.weather.model.entity.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Long> {

    public Weather findByUuid(String uuid);
}
