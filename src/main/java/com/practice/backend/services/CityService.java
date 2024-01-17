package com.practice.backend.services;

import com.practice.backend.models.City;
import com.practice.backend.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getCitiesDB() {
        List<City> cities = new ArrayList<>();
        cities = cityRepository.findAll(Sort.by(Sort.Direction.DESC, "cityId"));

        return cities;
    }

    public void addCityDB(String cityName) {
        cityRepository.save(new City(cityName));
    }
}
