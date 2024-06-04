package com.vm.cargosearch.integration.repository;

import com.vm.cargosearch.annotation.IT;
import com.vm.cargosearch.database.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

@IT
@RequiredArgsConstructor
public class ContactRepositoryTest {
    private final ContactRepository contactRepository;

    @Test
    void findByContactNameTest() {
        String pwd = contactRepository.findByContactName("Bob")
                .stream()
                .map(contact -> contact.getPassword())
                .findFirst()
                .orElse(null);
        System.out.println(pwd);
    }
}