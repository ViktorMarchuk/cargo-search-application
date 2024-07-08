package com.vm.cargosearch.integration.service;

import com.vm.cargosearch.annotation.IT;
import com.vm.cargosearch.database.entity.*;
import com.vm.cargosearch.database.repository.*;
import com.vm.cargosearch.dto.CargoFilter;
import com.vm.cargosearch.dto.CountryReadDto;
import com.vm.cargosearch.dto.KindOfTransportReadDto;
import com.vm.cargosearch.service.CargoService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Commit;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@IT
@RequiredArgsConstructor
public class CargoServiceTestIT {
    private final CargoService cargoService;
    private final ContactRepository contactRepository;
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final KindOfTransportRepository kindOfTransportRepository;
    private final CargoRepository cargoRepository;
    private final Long CARGO_ID = 3L;
    private final int EXPECTED_PRICE = 4800;

//    @Test
//    void getAllLoadingsByContactNameTest(){
//        List<Cargo> cargos = cargoService.getAllLoadingsByContactName("Anna");
//        System.out.println("Cargos: " + cargos);
//        Assertions.assertEquals(cargos.size(), 8);
//    }
//
//    @Test
//    void getContactFromCargoTest(){
//        String result = cargoService.getContactFromCargo(4L);
//        System.out.println("Result: " + result);
//        Assertions.assertEquals("Anna", result);
//    }
//
//    @Test
//    void findAllTest() {
//        var cargo = cargoService.findAll();
//        List<Long> actualResult = cargo.stream()
//                .map(c -> c.id())
//                .collect(Collectors.toList());
//
//        assertThat(actualResult).hasSize(5);
//    }
//
//    @Test
//    void findByIdTest() {
//        var cargo = cargoService.findById(CARGO_ID);
//        Optional<Integer> actualPrice = cargo.stream()
//                .map(e -> e.price())
//                .findFirst();
//
//        assertThat(actualPrice.get()).isEqualTo(EXPECTED_PRICE);
//
//    }

//    @Test
//    void createTest() {
//        Country testCountryLoad = new Country(2, "LT");
//        City testCityLoad = new City(4, "Vilnius", testCountryLoad);
//        Country testCountryUnload = new Country(6, "CZ");
//        City testCityUnload = new City(15, "Praga", testCountryUnload);
//        KindOfTransport transport = new KindOfTransport(1, "Tilt");

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
//    }

//    @Test
//    @Commit
//    void updateTest() {
//        Country testCountryLoad = countryRepository.findCountryById(8).orElseThrow(()->new IllegalArgumentException("Country not found"));
//        City testCityLoad = cityRepository.findById(19).orElseThrow(()->new IllegalArgumentException("City not found"));
//        Country testCountryUnload = countryRepository.findCountryById(8).orElseThrow(()->new IllegalArgumentException("Country not found"));
//        City testCityUnload = cityRepository.findById(19).orElseThrow(()->new IllegalArgumentException("City not found"));
//        KindOfTransport transport = kindOfTransportRepository.findById(2).orElseThrow(()->new IllegalArgumentException("Transport not found"));
//        Contact existingContact = contactRepository.findById(1).orElseThrow(() -> new IllegalArgumentException("Contact not found"));
////
//        CargoEditDto expectedResult = new CargoEditDto(
//                CARGO_ID,
//                LocalDate.now(),
//                testCountryLoad,
//                testCityLoad,
//                testCountryUnload,
//                testCityUnload,
//                transport,
//                "ADR 8 kl",
//                4800);
//        Optional<CargoReadDto> result = cargoService.update(CARGO_ID, expectedResult);
//        System.out.println(result);

//        List<CargoReadDto> actualResult = result.stream().collect(Collectors.toList());
//        Optional<String> countryLoadActual = actualResult.stream().map(c -> c.countryLoad().name()).findFirst();
//        Optional<String> cityLoadActual = actualResult.stream().map(c -> c.cityLoad().name()).findFirst();
//        Optional<String> countryUnloadActual = actualResult.stream().map(c -> c.countryUnload().name()).findFirst();
//        Optional<String> cityUnloadActual = actualResult.stream().map(c -> c.cityUnload().name()).findFirst();
//        Optional<String> transportActual = actualResult.stream().map(c -> c.kindOfTransport().name()).findFirst();
//        Optional<String> loadNameActual = actualResult.stream().map(c -> c.nameOfLoad()).findFirst();
//        Optional<Integer> actualPrice = actualResult.stream().map(c -> c.price()).findFirst();
//
//
//        assertTrue(result.isPresent());
//        assertEquals(expectedResult.getCountryLoad().getName(), countryLoadActual.get());
//        assertEquals(expectedResult.getCityLoad().getName(), cityLoadActual.get());
//        assertEquals(expectedResult.getCountryUnload().getName(), countryUnloadActual.get());
//        assertEquals(expectedResult.getCityUnload().getName(), cityUnloadActual.get());
//        assertEquals(expectedResult.getKindOfTransport().getName(), transportActual.get());
//        assertEquals(expectedResult.getNameOfLoad(), loadNameActual.get());
//        assertEquals(expectedResult.getPrice(), actualPrice.get());
//    }
}
