package com.vm.cargosearch.database.repository;

import com.vm.cargosearch.database.entity.Cargo;
import com.vm.cargosearch.dto.CargoFilter;

import java.util.List;

public interface FilterCargoRepository {
    List<Cargo> findAllByFilter(CargoFilter filter);
}
