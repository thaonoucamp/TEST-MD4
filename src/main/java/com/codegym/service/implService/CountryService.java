package com.codegym.service.implService;

import com.codegym.model.Country;
import com.codegym.repository.ICountryRepository;
import com.codegym.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService implements ICountryService {
    @Autowired
    ICountryRepository ICountryRepository;

    @Override
    public Iterable<Country> findAll() {
        return ICountryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return ICountryRepository.findById(id);
    }

    @Override
    public Country save(Country country) {
        return ICountryRepository.save(country);
    }

    @Override
    public void delete(Long id) {
        ICountryRepository.existsById(id);
    }
}
