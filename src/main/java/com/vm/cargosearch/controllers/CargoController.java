package com.vm.cargosearch.controllers;

import com.vm.cargosearch.dto.CargoCreateEditDto;
import com.vm.cargosearch.service.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cargo")
@RequiredArgsConstructor
public class CargoController {
    private final CargoService cargoService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("cargo", cargoService.findAll());
        return "/cargo";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cargoOne", cargoService.findById(id));

        return "/cargo_one";
    }

    @PostMapping
    public String create(@ModelAttribute CargoCreateEditDto cargo) {
        cargoService.create(cargo);
        return "redirect:/cargo/ + 25";

    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute CargoCreateEditDto cargo) {
        cargoService.update(id, cargo);
        return "redirect:/cargo/{id}";

    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        cargoService.delete(id);
        return "redirect:/cargo";

    }
}
