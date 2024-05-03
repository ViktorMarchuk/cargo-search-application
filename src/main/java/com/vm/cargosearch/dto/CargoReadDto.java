package com.vm.cargosearch.dto;

import lombok.Value;

import java.time.LocalDate;


public record CargoReadDto(Long id,
                           LocalDate loadDate,
                           CountryReadDto countryLoad,
                           CityReadDto cityLoad,
                           CountryReadDto countryUnload,
                           CityReadDto cityUnload,
                           KindOfTransportReadDto kindOfTransport,
                           String nameOfLoad,
                           int price,
                           String contact) {
}
