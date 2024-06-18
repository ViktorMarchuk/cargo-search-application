package com.vm.cargosearch.dto;

import com.vm.cargosearch.database.entity.City;
import com.vm.cargosearch.database.entity.Contact;
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
    Long id;

    @FutureOrPresent(message = "The date must be current or future")
    @NotNull(message = "Choose date")
    LocalDate loadDate;

    @NotNull(message = "Fill country name")
    Country countryLoad;

    @NotNull(message = "Fill city name")
    City cityLoad;

    @NotNull(message = "Fill country name")
    Country countryUnload;

    @NotNull(message = "Fill city name")
    City cityUnload;

    @NotNull(message = "Fill kind of transport")
    KindOfTransport kindOfTransport;

    @NotBlank(message = "Fill name of load")
    String nameOfLoad;

    Integer price;

    Contact contact;
}