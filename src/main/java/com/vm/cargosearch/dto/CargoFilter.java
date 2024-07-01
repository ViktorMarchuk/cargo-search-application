package com.vm.cargosearch.dto;

import java.time.LocalDate;

public record CargoFilter(LocalDate loadDateFrom,
                          LocalDate loadDate,
                          CountryReadDto countryLoad,
                          CountryReadDto countryUnload,
                          KindOfTransportReadDto kindOfTransport) {
}