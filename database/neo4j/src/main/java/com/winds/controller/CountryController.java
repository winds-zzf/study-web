package com.winds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.winds.domain.node.Country;
import com.winds.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/{name}")
    public Country getCountryByName(@PathVariable String name){
        return countryService.getCountryByName(name);
    }
}
