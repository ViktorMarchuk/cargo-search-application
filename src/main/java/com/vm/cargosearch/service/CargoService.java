package com.vm.cargosearch.service;

import com.vm.cargosearch.database.repository.CargoRepository;
import com.vm.cargosearch.dto.CargoCreateEditDto;
import com.vm.cargosearch.dto.CargoFilter;
import com.vm.cargosearch.dto.CargoReadDto;
import com.vm.cargosearch.mapper.CargoCreateEditMapper;
import com.vm.cargosearch.mapper.CargoReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CargoService {
    private final CargoRepository cargoRepository;
    private final CargoReadMapper cargoReadMapper;
    private final CargoCreateEditMapper cargoCreateEditMapper;

    public List<CargoReadDto> findAllByFilter(CargoFilter filter) {
        return cargoRepository.findAllByFilter(filter)
                .stream()
                .map(cargoReadMapper::map)
                .collect(Collectors.toList());
    }


    public List<CargoReadDto> findAll() {
        return cargoRepository.findAll()
                .stream()
                .map(cargoReadMapper::map)
                .collect(Collectors.toList());
    }

    public Optional<CargoReadDto> findById(Long id) {
        return cargoRepository
                .findById(id)
                .map(cargoReadMapper::map);
    }

    @Transactional
    public CargoReadDto create(CargoCreateEditDto cargo) {
        return Optional.of(cargo)
                .map(cargoCreateEditMapper::map)
                .map(cargoRepository::save)
                .map(cargoReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<CargoReadDto> update(Long id, CargoCreateEditDto cargo) {
        return cargoRepository.findById(id)
                .map(entity -> cargoCreateEditMapper.map(cargo, entity))
                .map(cargoRepository::saveAndFlush)
                .map(cargoReadMapper::map);
    }

    @Transactional
    public boolean delete(Long id) {
        return cargoRepository.findById(id)
                .map(entity -> {
                    cargoRepository.delete(entity);
                    cargoRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
