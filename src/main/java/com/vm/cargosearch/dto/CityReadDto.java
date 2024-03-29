package com.vm.cargosearch.dto;

import com.vm.cargosearch.database.entity.Country;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class CityReadDto {
    private Integer id;
    private String name;
    private CountryReadDto countryReadDto;

}
