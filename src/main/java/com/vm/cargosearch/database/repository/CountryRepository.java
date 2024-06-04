package com.vm.cargosearch.database.repository;

import com.vm.cargosearch.database.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Override
    Optional<Country> findById(Integer integer);

    Optional<Country> findCountryById(Integer id);

    @Query(value = "select c from Country c where c.name like %:keyword%")
    List<Country> findByKeyword(@Param("keyword") String keyword);

    List<Country> findCountryByNameContainingIgnoreCase(String keyword);
}
