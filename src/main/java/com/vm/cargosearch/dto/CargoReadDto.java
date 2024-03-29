package com.vm.cargosearch.dto;

import lombok.Value;

import java.time.LocalDate;
@Value
public class CargoReadDto {
    private Long id;
    private LocalDate loadDate;
    private CountryReadDto countryLoad;
    private CityReadDto cityLoad;
    private CountryReadDto countryUnload;
    private CityReadDto cityUnload;
    private KindOfTransportReadDto kindOfTransport;
    private String nameOfLoad;
    private int price;

}
