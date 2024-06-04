package com.vm.cargosearch.database.repository;

import com.vm.cargosearch.database.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Override
    Optional<Contact> findById(Integer integer);

    Optional<Contact> findByContactName(String contactName);
}
