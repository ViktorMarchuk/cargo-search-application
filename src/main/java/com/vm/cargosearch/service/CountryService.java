package com.vm.cargosearch.service;

import com.vm.cargosearch.database.entity.Country;
import com.vm.cargosearch.database.repository.CountryRepository;
import com.vm.cargosearch.dto.CountryReadDto;
import com.vm.cargosearch.mapper.CountryReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CountryService {
    private final CountryRepository countryRepository;
    private final CountryReadMapper countryReadMapper;

    public List<CountryReadDto> findAll() {
        return countryRepository.findAll()
                .stream()
                .map(countryReadMapper::map)
                .collect(Collectors.toList());
    }

    public List<CountryReadDto> findCountryById(Integer id) {
        return countryRepository.findCountryById(id)
                .stream()
                .map(countryReadMapper::map)
                .collect(Collectors.toList());
    }

    public List<String> findByCountryNameFilter(String keyword) {
        return countryRepository.findCountryByNameContainingIgnoreCase(keyword)
                .stream()
                .map(country -> country.getName())
                .toList();
    }

    public Optional<Country> findById(Integer id) {
       return countryRepository.findById(id);
    }
}
