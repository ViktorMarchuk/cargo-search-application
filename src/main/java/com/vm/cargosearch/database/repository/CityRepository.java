package com.vm.cargosearch.database.repository;

import com.vm.cargosearch.database.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Integer> {
    @Override
    Optional<City> findById(Integer integer);

    List<City> findCitiesByNameContainingIgnoreCase(String keyword);
}