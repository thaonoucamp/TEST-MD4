package com.codegym.service.implService;

import com.codegym.model.City;
import com.codegym.repository.ICityRepository;
import com.codegym.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements ICityService {
    @Autowired
    ICityRepository ICityRepository;

    @Override
    public Iterable<City> findAll() {
        return ICityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return ICityRepository.findById(id);
    }

    @Override
    public City save(City city) {
        return ICityRepository.save(city);
    }

    @Override
    public void delete(Long id) {
        ICityRepository.deleteById(id);
    }

    @Override
    public List<City> findAllByNameContaining(String name) {
        return ICityRepository.findAllByNameContaining(name);
    }
}
