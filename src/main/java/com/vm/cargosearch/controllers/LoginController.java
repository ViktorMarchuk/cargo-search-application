package com.vm.cargosearch.controllers;

import com.vm.cargosearch.dto.ContactCreateDto;
import com.vm.cargosearch.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String create(@ModelAttribute("newContact") @Validated ContactCreateDto contact,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "authorisation";
        }
        contactService.create(contact);

        return "redirect:/login";
    }

    @GetMapping("/contact_name/{id}")
    public String findByContactName(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("contact", contactService.findContactById(id));

        return "company_details";
    }
}