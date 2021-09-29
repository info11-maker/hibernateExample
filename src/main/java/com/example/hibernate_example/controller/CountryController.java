package com.example.hibernate_example.controller;
import com.example.hibernate_example.model.Country;
import com.example.hibernate_example.service.impl.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private CountryService countryService;

    public CountryController(CountryService countryService){
        super();
        this.countryService = countryService;
    }
    //create country
    @PostMapping
    public ResponseEntity<Country> create(@RequestBody Country country){
        return new ResponseEntity<Country>(countryService.save(country), HttpStatus.CREATED);
    }
    //get all countries
    @GetMapping
    public List<Country> getAll(){
        return countryService.getAll();
    }
    //getbyID
    @GetMapping("{id}")
    public ResponseEntity<Country> get(@PathVariable("id") long id){
    return new ResponseEntity<Country>(countryService.get(id),HttpStatus.OK);
    }
}