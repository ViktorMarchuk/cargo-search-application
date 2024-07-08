package com.vm.cargosearch.integration.repository;

import com.vm.cargosearch.annotation.IT;
import com.vm.cargosearch.database.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@IT
@RequiredArgsConstructor
public class CountryRepositoryTestIT {
//    private final CountryRepository countryRepository;
//    private final int COUNTRY_ID = 1;

//    @Test
//    void findByIdTest() {
//        var country = countryRepository.findById(COUNTRY_ID);
//        Optional<Integer> expectedID = country.stream().map(c -> c.getId()).findFirst();
//        assertThat(expectedID.get()).isEqualTo(COUNTRY_ID);
//    }
//
//    @Test
//    void findCountryByNameStartingWithTest() {
//        List<String> list = countryRepository.findCountryByNameStartingWith("D")
//                .stream()
//                .map(country -> country.getName())
//                .toList();
//        System.out.println(list);
//    }
}
