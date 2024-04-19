package com.vm.cargosearch.dto;

import com.vm.cargosearch.database.entity.City;
import com.vm.cargosearch.database.entity.Country;
import com.vm.cargosearch.database.entity.KindOfTransport;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@Data
@FieldNameConstants
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class CargoCreateEditDto {
    @FutureOrPresent(message = "The date must be current or future")
    @NotNull(message = "Choose date")
    LocalDate loadDate;

    Country countryLoad;

    City cityLoad;

    Country countryUnload;

    City cityUnload;

    KindOfTransport kindOfTransport;

    @NotBlank(message = "Fill name of load")
    String nameOfLoad;

    Integer price;
}