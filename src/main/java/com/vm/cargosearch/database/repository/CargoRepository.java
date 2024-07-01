package com.vm.cargosearch.database.repository;

import com.vm.cargosearch.database.entity.Cargo;
import com.vm.cargosearch.dto.CargoReadDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>, FilterCargoRepository {
    Optional<Cargo> findById(Long integer);
    List<Cargo> findAllByContactContactName(String name);
}

