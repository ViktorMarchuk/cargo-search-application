package com.vm.cargosearch.dto;

import com.vm.cargosearch.database.entity.City;
import com.vm.cargosearch.database.entity.Country;
import com.vm.cargosearch.database.entity.KindOfTransport;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@Value
@FieldNameConstants
public class CargoCreateEditDto {
    LocalDate loadDate;
    Country countryLoad;
    City cityLoad;
    Country countryUnload;
    City cityUnload;
    KindOfTransport kindOfTransport;
    String nameOfLoad;
    Integer price;
}
