package com.winds.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.winds.domain.node.Country;
import com.winds.repository.CountryRepository;
import com.winds.service.CountryService;

@Service("CountryService")
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public Country getCountryByName(String name) {
        return countryRepository.findFirstByName(name);
    }
}
