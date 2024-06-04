package com.vm.cargosearch.service;

import com.vm.cargosearch.database.entity.Contact;
import com.vm.cargosearch.database.repository.ContactRepository;
import com.vm.cargosearch.dto.ContactCreateDto;
import com.vm.cargosearch.dto.ContactReadDto;
import com.vm.cargosearch.mapper.ContactCreateMapper;
import com.vm.cargosearch.mapper.ContactReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContactService implements UserDetailsService {
    private final ContactRepository contactRepository;
    private final ContactCreateMapper contactCreateMapper;
    private final ContactReadMapper contactReadMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return contactRepository.findByContactName(userName)
                .map(contact -> new org.springframework.security.core.userdetails.User(
                        contact.getContactName(),
                        contact.getPassword(),
                        Collections.EMPTY_LIST
                ))
                .orElseThrow(() -> new UsernameNotFoundException("Failed to retrieve user: " + userName));
    }

    @Transactional
    public ContactReadDto create(ContactCreateDto contact) {
        return Optional.of(contact)
                .map(contactCreateMapper::map)
                .map(contactRepository::save)
                .map(contactReadMapper::map)
                .orElseThrow();
    }
}
