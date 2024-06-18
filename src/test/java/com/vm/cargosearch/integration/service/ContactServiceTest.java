package com.vm.cargosearch.integration.service;

import com.vm.cargosearch.annotation.IT;
import com.vm.cargosearch.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@IT
@RequiredArgsConstructor
public class ContactServiceTest {
    private final ContactService contactService;

    @Test
    void getIdByNameTest() {
        Integer id = contactService.getIdByName("Loh");
        System.out.println(id);
    }
}
