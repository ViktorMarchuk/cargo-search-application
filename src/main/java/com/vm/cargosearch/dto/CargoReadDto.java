package com.vm.cargosearch.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;
@Value
public class CargoReadDto {
    private Long id;
    @FutureOrPresent(message = "The date must be current or future")
    @NotNull(message = "Choose date")
    private LocalDate loadDate;
    private CountryReadDto countryLoad;
    private CityReadDto cityLoad;
    private CountryReadDto countryUnload;
    private CityReadDto cityUnload;
    private KindOfTransportReadDto kindOfTransport;
    private String nameOfLoad;
    private int price;

}
