package com.vm.cargosearch.controllers;

import com.vm.cargosearch.dto.ContactCreateDto;
import com.vm.cargosearch.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final ContactService contactService;

    @GetMapping("/login")
    public String loginPage() {
        return "/login";
    }

    @GetMapping("/authorisation")
    public String authorisationPage(Model model) {
        model.addAttribute("newContact", new ContactCreateDto());
        return "authorisation";
    }

    @PostMapping("/authorisation")
    public String create(@ModelAttribute("newContact") ContactCreateDto contact) {
        contactService.create(contact);
        return "redirect:/login";
    }

    @GetMapping("/{contactName}")
    public String findByContactName(@PathVariable("contactName") String contactName) {
        return "company";
    }
}


//@Controller
//@RequiredArgsConstructor
//public class LoginController {
//    private final ContactService contactService;
//
//    @GetMapping("/authorisation")
//    public String authorisationPage(Model model) {
//        model.addAttribute("newContact", new ContactCreateDto());
//        return "authorisation";
//    }
//
//    @PostMapping("/authorisation")
//    public String create(@ModelAttribute("newContact") ContactCreateDto contact) {
//        contactService.create(contact);
//        return "redirect:/login";
//    }
//}
