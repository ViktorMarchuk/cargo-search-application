package com.vm.cargosearch.mapper;

import com.vm.cargosearch.database.entity.Contact;
import com.vm.cargosearch.dto.ContactCreateDto;
import org.springframework.stereotype.Component;

@Component
public class ContactCreateMapper implements Mapper<ContactCreateDto, Contact> {

    @Override
    public Contact map(ContactCreateDto object) {
        Contact contact = new Contact();
        copy(object, contact);
        return contact;
    }

    @Override
    public Contact map(ContactCreateDto fromObject, Contact toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    private void copy(ContactCreateDto object, Contact contact) {
        if (object.getId() != null) {
            contact.setId(object.getId());
        }
        if (object.getCompanyName() != null) {
            contact.setCompanyName(object.getCompanyName());
        }
        if (object.getAddress() != null) {
            contact.setAddress(object.getAddress());
        }
        if (object.getEmail() != null) {
            contact.setEmail(object.getEmail());
        }
        if (object.getTelephone() != null) {
            contact.setTelephone(object.getTelephone());
        }
        if (object.getContactName() != null) {
            contact.setContactName(object.getContactName());
        }
        if (object.getPassword() != null) {
            contact.setPassword("{noop}" + object.getPassword());
        }
    }
}
