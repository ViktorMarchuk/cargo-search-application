package com.vm.cargosearch.mapper;

import com.vm.cargosearch.database.entity.Country;
import com.vm.cargosearch.dto.CountryReadDto;
import org.springframework.stereotype.Component;

@Component
public class CountryReadMapper implements Mapper<Country, CountryReadDto> {
    @Override
    public CountryReadDto map(Country object) {
        return new CountryReadDto(object.getId(), object.getName());
    }
}
