package com.vm.cargosearch.database.repository;

import com.vm.cargosearch.database.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {

    Optional<Cargo> findById(Long integer);
}
