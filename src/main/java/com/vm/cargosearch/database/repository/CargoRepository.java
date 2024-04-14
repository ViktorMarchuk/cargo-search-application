package com.vm.cargosearch.database.repository;

import com.vm.cargosearch.database.entity.Cargo;
import com.vm.cargosearch.dto.CargoFilter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CargoRepository extends JpaRepository<Cargo, Integer>, FilterCargoRepository {
    Optional<Cargo> findById(Long integer);
}
