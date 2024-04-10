package com.vm.cargosearch.service;

import com.vm.cargosearch.database.repository.CityRepository;
import com.vm.cargosearch.dto.CityReadDto;
import com.vm.cargosearch.mapper.CityReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CityService {
    private final CityRepository cityRepository;
    private final CityReadMapper cityReadMapper;

    public List<CityReadDto> findAll() {
        return cityRepository.findAll()
                .stream()
                .map(cityReadMapper::map)
                .collect(Collectors.toList());
    }
}
