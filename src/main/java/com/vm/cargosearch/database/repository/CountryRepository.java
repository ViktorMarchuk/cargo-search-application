package com.vm.cargosearch.database.repository;

import com.vm.cargosearch.database.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Override
    Optional<Country> findById(Integer integer);

}
