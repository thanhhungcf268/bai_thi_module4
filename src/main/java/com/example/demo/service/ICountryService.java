package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.model.Country;

public interface ICountryService {

    Iterable<Country> findAll();

}
