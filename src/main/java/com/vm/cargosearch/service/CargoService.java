package com.vm.cargosearch.service;

import com.vm.cargosearch.database.repository.CargoRepository;
import com.vm.cargosearch.mapper.CargoMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class CargoService {
    private final CargoMapper cargoMapper;
    private final CargoRepository cargoRepository;
}
