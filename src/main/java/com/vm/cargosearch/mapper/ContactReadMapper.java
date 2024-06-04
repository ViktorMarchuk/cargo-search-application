package com.vm.cargosearch.mapper;

import com.vm.cargosearch.database.entity.Contact;
import com.vm.cargosearch.dto.ContactReadDto;
import org.springframework.stereotype.Component;

@Component
public class ContactReadMapper implements Mapper<Contact, ContactReadDto> {
    @Override
    public ContactReadDto map(Contact object) {
        return new ContactReadDto(object.getId(),
                object.getCompanyName(),
                object.getAddress(),
                object.getEmail(),
                object.getTelephone(),
                object.getContactName(),
                object.getPassword());
    }
}
