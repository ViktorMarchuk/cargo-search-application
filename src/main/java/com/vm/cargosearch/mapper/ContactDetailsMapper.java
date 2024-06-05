package com.vm.cargosearch.mapper;

import com.vm.cargosearch.database.entity.Contact;
import com.vm.cargosearch.dto.ContactDetailsDto;
import org.springframework.stereotype.Component;

@Component
public class ContactDetailsMapper implements Mapper<Contact, ContactDetailsDto> {
    @Override
    public ContactDetailsDto map(Contact object) {
        return new ContactDetailsDto(object.getId(),
                object.getCompanyName(),
                object.getAddress(),
                object.getEmail(),
                object.getTelephone(),
                object.getContactName());
    }
}
