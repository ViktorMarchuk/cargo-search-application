package com.vm.cargosearch.controllers;

import com.vm.cargosearch.dto.CargoCreateEditDto;
import com.vm.cargosearch.dto.CargoReadDto;
import com.vm.cargosearch.service.CargoService;
import com.vm.cargosearch.service.CityService;
import com.vm.cargosearch.service.CountryService;
import com.vm.cargosearch.service.KindOfTransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/cargo")
@RequiredArgsConstructor
public class CargoController {
    private final CargoService cargoService;
    private final CountryService countryService;
    private final CityService cityService;
    private final KindOfTransportService kindOfTransportService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("cargo", cargoService.findAll());
        return "cargo_all";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        return cargoService.findById(id)
                .map(cargo -> {
                    model.addAttribute("cargo", cargo);
                    model.addAttribute("country", countryService.findByAll());
                    model.addAttribute("city", cityService.findAll());
                    model.addAttribute("transport", kindOfTransportService.findAll());
                    return "/cargo";
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public String create(@ModelAttribute CargoCreateEditDto cargo) {
        CargoReadDto dto = cargoService.create(cargo);
        return "redirect:/cargo/" + dto.getId();

    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute CargoCreateEditDto cargo) {
        return cargoService.update(id, cargo)
                .map(it -> "redirect:/cargo/{id}")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //@PostMapping("/{id}/delete")
    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        if (!cargoService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "redirect:/cargo";
    }
}
