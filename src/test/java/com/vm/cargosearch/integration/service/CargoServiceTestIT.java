package com.vm.cargosearch.integration.service;

import com.vm.cargosearch.annotation.IT;
import com.vm.cargosearch.database.entity.City;
import com.vm.cargosearch.database.entity.Country;
import com.vm.cargosearch.database.entity.KindOfTransport;
import com.vm.cargosearch.dto.CargoCreateEditDto;
import com.vm.cargosearch.dto.CargoReadDto;
import com.vm.cargosearch.service.CargoService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@RequiredArgsConstructor
public class CargoServiceTestIT {
    private final CargoService cargoService;
    private final Long CARGO_ID = 1L;
    private final int EXPECTED_PRICE = 4800;


    @Test
    void findAllTest() {
        var cargo = cargoService.findAll();
        List<Long> actualResult = cargo.stream()
                .map(c -> c.getId())
                .collect(Collectors.toList());

        assertThat(actualResult).hasSize(5);
    }

    @Test
    void findByIdTest() {
        var cargo = cargoService.findById(CARGO_ID);
        Optional<Integer> actualPrice = cargo.stream()
                .map(e -> e.getPrice())
                .findFirst();

        assertThat(actualPrice.get()).isEqualTo(EXPECTED_PRICE);

    }

    @Test
    void createTest() {
        Country testCountryLoad = new Country(2, "LT");
        City testCityLoad = new City(4, "Vilnius", testCountryLoad);
        Country testCountryUnload = new Country(6, "CZ");
        City testCityUnload = new City(15, "Praga", testCountryUnload);
        KindOfTransport transport = new KindOfTransport(1, "Tilt");

//        CargoCreateEditDto expectedResult = new CargoCreateEditDto(
//                LocalDate.now(),
//                testCountryLoad,
//                testCityLoad,
//                testCountryUnload,
//                testCityUnload,
//                transport,
//                "ADR 8 kl",
//                4800);

//        CargoReadDto actualResult = cargoService.create(expectedResult);
//        assertEquals(actualResult.getCountryLoad().name(), expectedResult.getCountryLoad().getName());
//        assertEquals(actualResult.getCityLoad().name(), expectedResult.getCityLoad().getName());
//        assertEquals(actualResult.getCountryUnload().name(), expectedResult.getCountryUnload().getName());
//        assertEquals(actualResult.getKindOfTransport().name(), expectedResult.getKindOfTransport().getName());
//        assertEquals(actualResult.getNameOfLoad(), expectedResult.getNameOfLoad());
//        assertEquals(actualResult.getPrice(), expectedResult.getPrice());
    }

    @Test
    void updateTest() {
//        Country testCountryLoad = new Country(2, "LT");
//        City testCityLoad = new City(4, "Vilnius", testCountryLoad);
//        Country testCountryUnload = new Country(6, "CZ");
//        City testCityUnload = new City(15, "Praga", testCountryUnload);
//        KindOfTransport transport = new KindOfTransport(1, "Tilt");
//
//        CargoCreateEditDto expectedResult = new CargoCreateEditDto(
//                LocalDate.now(),
//                testCountryLoad,
//                testCityLoad,
//                testCountryUnload,
//                testCityUnload,
//                transport,
//                "ADR 8 kl",
//                4800);
//        Optional<CargoReadDto> result = cargoService.update(CARGO_ID, expectedResult);
//
//        List<CargoReadDto> actualResult = result.stream().collect(Collectors.toList());
//        Optional<String> countryLoadActual = actualResult.stream().map(c -> c.getCountryLoad().name()).findFirst();
//        Optional<String> cityLoadActual = actualResult.stream().map(c -> c.getCityLoad().name()).findFirst();
//        Optional<String> countryUnloadActual = actualResult.stream().map(c -> c.getCountryUnload().name()).findFirst();
//        Optional<String> cityUnloadActual = actualResult.stream().map(c -> c.getCityUnload().name()).findFirst();
//        Optional<String> transportActual = actualResult.stream().map(c -> c.getKindOfTransport().name()).findFirst();
//        Optional<String> loadNameActual = actualResult.stream().map(c -> c.getNameOfLoad()).findFirst();
//        Optional<Integer> actualPrice = actualResult.stream().map(c -> c.getPrice()).findFirst();
//
//        assertTrue(result.isPresent());
//        assertEquals(expectedResult.getCountryLoad().getName(), countryLoadActual.get());
//        assertEquals(expectedResult.getCityLoad().getName(), cityLoadActual.get());
//        assertEquals(expectedResult.getCountryUnload().getName(), countryUnloadActual.get());
//        assertEquals(expectedResult.getCityUnload().getName(), cityUnloadActual.get());
//        assertEquals(expectedResult.getKindOfTransport().getName(), transportActual.get());
//        assertEquals(expectedResult.getNameOfLoad(), loadNameActual.get());
//        assertEquals(expectedResult.getPrice(), actualPrice.get());
    }
}
