package com.vm.cargosearch.controllers;

import com.vm.cargosearch.database.entity.Country;
import com.vm.cargosearch.database.entity.KindOfTransport;
import com.vm.cargosearch.dto.*;
import com.vm.cargosearch.service.CargoService;
import com.vm.cargosearch.service.CityService;
import com.vm.cargosearch.service.CountryService;
import com.vm.cargosearch.service.KindOfTransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/cargo")
@RequiredArgsConstructor
public class CargoController {
    private final CargoService cargoService;
    private final CountryService countryService;
    private final CityService cityService;
    private final KindOfTransportService kindOfTransportService;

    @GetMapping
    public String findAll(Model model,
                          @RequestParam(value = "loadDateFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate loadDateFrom,
                          @RequestParam(value = "loadDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate loadDate,
                          @RequestParam(value = "countryLoad", required = false) String countryLoadName,
                          @RequestParam(value = "countryUnload", required = false) String countryUnloadName,
                          @RequestParam(value = "kindOfTransport", required = false) String kindOfTransportName) {

        CountryReadDto countryLoad = countryLoadName != null ? new CountryReadDto(null, countryLoadName) : null;
        CountryReadDto countryUnload = countryUnloadName != null ? new CountryReadDto(null, countryUnloadName) : null;
        KindOfTransportReadDto kindOfTransport = kindOfTransportName != null ? new KindOfTransportReadDto(null, kindOfTransportName) : null;
        CargoFilter filter = new CargoFilter(loadDateFrom, loadDate, countryLoad, countryUnload, kindOfTransport);
        model.addAttribute("cargo", cargoService.findAllByFilter(filter));

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

    @PostMapping("/create")
    public String create(@ModelAttribute CargoCreateEditDto cargo, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("cargo", cargo);
            return "redirect:/cargo/registration";
        }
        CargoReadDto dto = cargoService.create(cargo);
        return "redirect:/cargo";

    }

    //    @PostMapping("/{id}/update")
//    public String update(@PathVariable("id") Long id, @ModelAttribute CargoCreateEditDto cargo) {
//        return cargoService.update(id, cargo)
//                .map(it -> "redirect:/cargo/{id}")
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }
    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id,
                         @ModelAttribute @Validated CargoCreateEditDto cargo) {
        Optional<CargoReadDto> updatedCargo = cargoService.update(id, cargo);
        if (updatedCargo.isPresent()) {
            return "redirect:/cargo";

        }
        return "redirect:/cargo/{id}";
    }


    @PostMapping("/{id}/delete")
//    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        if (!cargoService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "redirect:/cargo";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("newCargo", new CargoCreateEditDto());
        model.addAttribute("country", countryService.findByAll());
        model.addAttribute("city", cityService.findAll());
        model.addAttribute("transport", kindOfTransportService.findAll());
        return "/create_cargo";
    }
}