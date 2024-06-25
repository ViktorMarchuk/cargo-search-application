package com.vm.cargosearch.integration.service;

import com.vm.cargosearch.annotation.IT;
import com.vm.cargosearch.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;

@IT
@RequiredArgsConstructor
public class ContactServiceTest {
    private final ContactService contactService;

    @Test
    void getIdByNameTest() {
        Integer id = contactService.getIdByName("Loh");
        System.out.println(id);
    }
//    @Test
//    void getContactNameByIDTest(){
//        String contactName = contactService.getContactNameByID(1L);
//        System.out.println(contactName);
//        Assertions.assertEquals(contactName,"Anna");
//    }
//    @Test
//    @WithMockUser(username = "Loch")
//    void isSpecificUserTest(){
//        boolean result=contactService.isSpecificUser("Loch");
//        System.out.println("Result :" + result);
//        Assertions.assertEquals(true,result);
//    }

    @Test
    void findContactNameByIdTest(){
        String result = contactService.findContactNameById(1);
        System.out.println("Contact name " + result);
        Assertions.assertEquals("Anna", result);
    }
}
