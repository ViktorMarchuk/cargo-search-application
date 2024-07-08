package com.vm.cargosearch.integration.repository;


import com.vm.cargosearch.annotation.IT;
import com.vm.cargosearch.database.entity.Cargo;
import com.vm.cargosearch.database.entity.City;
import com.vm.cargosearch.database.entity.Country;
import com.vm.cargosearch.database.entity.KindOfTransport;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@IT
@RequiredArgsConstructor

public class CargoRepositoryTestIT {

//    private final EntityManager entityManager;

//    @Test
//    void findById() {
//        var cargo = entityManager.find(Cargo.class, 1);
//        assertNotNull(cargo);
//        assertThat(cargo.getId().equals(1));
//
//    }
//
//    @Test
//    void findByCity() {
//        var city = entityManager.find(City.class, 1);
//        Assertions.assertEquals(city.getName(), "Minsk");
//    }
//
//    @Test
//    void save() {
//        var country = Country.builder()
//                .name("Angola")
//                .build();
//        entityManager.persist(country);
//        assertNotNull(country);
//        Assertions.assertEquals(country.getName(), "Angola");
//    }
//
//    @Test
//    void delete() {
//        var country = entityManager.find(Country.class, 10);
//        entityManager.remove(country);
//        var removeCountry = entityManager.find(Country.class, 10);
//        assertNull(removeCountry);
//
//    }
//
//    @Test
//    void saveCargo() {
//        var countryLoad = entityManager.find(Country.class, 8);
//        var cityLoad = entityManager.find(City.class, 19);
//        var countryUnload = entityManager.find(Country.class, 1);
//        var cityUnload = entityManager.find(City.class, 3);
//        var transport = entityManager.find(KindOfTransport.class, 2);
//
//        var cargo = Cargo.builder()
//                .loadDate(LocalDate.of(2024, 04, 15))
//                .countryLoad(countryLoad)
//                .cityLoad(cityLoad)
//                .countryUnload(countryUnload)
//                .cityUnload(cityUnload)
//                .kindOfTransport(transport)
//                .nameOfLoad("Fish on a boxes")
//                .price(4500)
//                .build();
//        entityManager.persist(cargo);
//        assertNotNull(cargo);
//        assertThat(cargo.getCityLoad().getName()).isEqualTo("London");
//
//    }
}
