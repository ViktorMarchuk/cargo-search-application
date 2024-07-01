package com.vm.cargosearch.service;

import com.vm.cargosearch.database.entity.Cargo;
import com.vm.cargosearch.database.repository.*;
import com.vm.cargosearch.dto.*;
import com.vm.cargosearch.mapper.CargoCreateEditMapper;
import com.vm.cargosearch.mapper.CargoReadMapper;
import com.vm.cargosearch.mapper.CargoUpdateMapper;
import com.vm.cargosearch.mapper.CargoUpdateReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private final CargoUpdateMapper cargoUpdateMapper;
    private final CargoUpdateReadMapper cargoUpdateReadMapper;
    private final ContactService contactService;

    public List<Cargo> getAllLoadingsByContactName(String name) {
        return cargoRepository
                .findAllByContactContactName(name)
                .stream()
                .toList();

    }

    public String getContactFromCargo(Long cargoID) {
        return cargoRepository
                .findById(cargoID)
                .stream()
                .map(cargo -> cargo.getContact().getContactName())
                .findFirst()
                .orElse("Contact Not Found");
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
    public Optional<CargoUpdateReadDto> update(Long id, CargoUpdateDto cargo) {
        return cargoRepository.findById(id)
                .map(entity -> cargoUpdateMapper.map(cargo, entity))
                .map(cargoRepository::saveAndFlush)
                .map(cargoUpdateReadMapper::map);
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

    public Page<Cargo> findByPage(int pageNo, int pageSize, CargoFilter filter) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        List<Cargo> filteredCargo = cargoRepository.findAllByFilter(filter);
        int start = (int) pageable.getOffset();
        int end = (start + pageable.getPageSize()) > filteredCargo.size() ? filteredCargo.size() : (start + pageable.getPageSize());
        return new PageImpl<>(filteredCargo.subList(start, end), pageable, filteredCargo.size());
    }
}
