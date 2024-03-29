package com.vm.cargosearch.database.repository;

import com.vm.cargosearch.database.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
