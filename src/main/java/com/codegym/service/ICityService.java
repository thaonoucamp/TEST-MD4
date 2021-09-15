package com.codegym.service;

import com.codegym.model.City;

import java.util.List;

public interface ICityService extends IGeneralService<City> {
    List<City> findAllByNameContaining(String name);

}
