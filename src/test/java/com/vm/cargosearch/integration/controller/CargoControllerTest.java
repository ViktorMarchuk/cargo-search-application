package com.vm.cargosearch.integration.controller;

import com.vm.cargosearch.annotation.IT;
import com.vm.cargosearch.dto.CargoCreateEditDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IT
@RequiredArgsConstructor
@AutoConfigureMockMvc
public class CargoControllerTest {
    private final MockMvc mockMvc;

//    @Test
//    void findAllTest() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/cargo"))
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(MockMvcResultMatchers.view().name("/cargo"))
//                .andExpect(MockMvcResultMatchers.model().attributeExists("cargo"))
//                .andExpect(MockMvcResultMatchers.model().attribute("cargo", hasSize(6)));
//    }
//
//    @Test
//    void createTest() throws Exception {
//        mockMvc.perform(post("/cargo")
//                        .param(CargoCreateEditDto.Fields.loadDate, "2024-03-04")
//                        .param(CargoCreateEditDto.Fields.countryLoad, "1")
//                        .param(CargoCreateEditDto.Fields.cityLoad, "1")
//                        .param(CargoCreateEditDto.Fields.countryUnload, "4")
//                        .param(CargoCreateEditDto.Fields.cityUnload, "7")
//                        .param(CargoCreateEditDto.Fields.kindOfTransport, "1")
//                        .param(CargoCreateEditDto.Fields.nameOfLoad, "test")
//                        .param(CargoCreateEditDto.Fields.price, "1000")
//                )
//                .andExpectAll(status().is3xxRedirection(),
//                        redirectedUrlPattern("/cargo/{\\d+}"));
//    }
//
//    @Test
//    void findByIdTest() throws Exception {
//        int idDeleteCargo = 2;
//        mockMvc.perform(MockMvcRequestBuilders.get("/cargo/{id}", idDeleteCargo))
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(MockMvcResultMatchers.view().name("/cargo_one"))
//                .andExpect(MockMvcResultMatchers.model().attributeExists("cargo_one"));
//    }
//
//    @Test
//    void deleteTest() throws Exception {
//        int idDeleteCargo = 3;
//        mockMvc.perform(delete("/cargo/{id}/delete", idDeleteCargo))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(MockMvcResultMatchers.view().name("redirect:/cargo"));
//    }
}
