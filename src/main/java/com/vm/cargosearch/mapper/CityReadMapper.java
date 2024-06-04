package com.vm.cargosearch.mapper;

import com.vm.cargosearch.database.entity.City;
import com.vm.cargosearch.dto.CityReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CityReadMapper implements Mapper<City, CityReadDto> {
    private final CountryReadMapper countryReadMapper;

    @Override
    public CityReadDto map(City object) {
        return new CityReadDto(object.getId(), object.getName());
    }
}
