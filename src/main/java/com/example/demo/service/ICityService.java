package com.example.demo.service;


import com.example.demo.model.City;

import java.util.Optional;

public interface ICityService {

    Iterable<City> findAll();

    void deleteById(Long id);

    City save(City city);

    Optional<City> findById(Long id);

}
