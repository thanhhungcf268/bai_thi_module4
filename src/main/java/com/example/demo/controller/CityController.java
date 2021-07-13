package com.example.demo.controller;


import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.service.ICityService;
import com.example.demo.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CityController {

@Autowired
private ICountryService countryService;

@Autowired
private ICityService cityService;

    @GetMapping("/")
    public ModelAndView getListCity(){

        Iterable<City> cities = cityService.findAll();
        Iterable<Country> countries = countryService.findAll();

        return new ModelAndView("index","citys",cities);
    }


    @GetMapping("/list")
    public ResponseEntity<Iterable<City>> getList(){
        return new ResponseEntity<>(cityService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/country")
    public ResponseEntity<Iterable<Country>> getListCountry(){
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> save(@RequestBody City city){
        return new ResponseEntity<>(cityService.save(city),HttpStatus.CREATED);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id){
        return new ResponseEntity<>(cityService.findById(id).get(),HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<City> edit(@RequestBody City city){
        return new ResponseEntity<>(cityService.save(city),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> deleta(@PathVariable Long id){
        cityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
