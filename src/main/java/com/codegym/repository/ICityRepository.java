package com.codegym.repository;

import com.codegym.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICityRepository extends CrudRepository<City, Long> {
    List<City> findAllByNameContaining(String name);
}
