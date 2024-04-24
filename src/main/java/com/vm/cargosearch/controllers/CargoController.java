package com.vm.cargosearch.controllers;

import com.vm.cargosearch.database.entity.Cargo;
import com.vm.cargosearch.database.entity.Country;
import com.vm.cargosearch.database.entity.KindOfTransport;
import com.vm.cargosearch.dto.*;
import com.vm.cargosearch.service.CargoService;
import com.vm.cargosearch.service.CityService;
import com.vm.cargosearch.service.CountryService;
import com.vm.cargosearch.service.KindOfTransportService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public String findById(@PathVariable("id") Long id,
                           Model model,
                           HttpSession session) {
        CargoCreateEditDto updateCargo = (CargoCreateEditDto) session.getAttribute("cargo");
        if (updateCargo == null) {
            updateCargo = new CargoCreateEditDto();
        }
        CargoCreateEditDto finalUpdateCargo = updateCargo;
        return cargoService.findById(id)
                .map(cargo -> {
                    model.addAttribute("cargo", cargo);
                    model.addAttribute("updateCargo", finalUpdateCargo);
                    model.addAttribute("country", countryService.findByAll());
                    model.addAttribute("city", cityService.findAll());
                    model.addAttribute("transport", kindOfTransportService.findAll());
                    return "/cargo";
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("newCargo") @Validated CargoCreateEditDto cargo,
                         BindingResult bindingResult,
                         HttpSession session,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.newCargo", bindingResult);
            redirectAttributes.addFlashAttribute("newCargo", cargo);
            session.setAttribute("newCargo", cargo);
            return "redirect:/cargo/registration";
        }
        cargoService.create(cargo);
        session.removeAttribute("newCargo"); // Очищаем объект newCargo из сессии после успешного создания
        return "redirect:/cargo";
    }

    @GetMapping("/registration")
    public String registration(HttpSession session, Model model) {
        CargoCreateEditDto newCargo = (CargoCreateEditDto) session.getAttribute("newCargo");
        if (newCargo == null) {
            newCargo = new CargoCreateEditDto();
        }
        model.addAttribute("newCargo", newCargo);
        model.addAttribute("country", countryService.findByAll());
        model.addAttribute("city", cityService.findAll());
        model.addAttribute("transport", kindOfTransportService.findAll());
        session.removeAttribute("newCargo");
        return "/create_cargo";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id,
                         @ModelAttribute @Validated CargoCreateEditDto cargo,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("cargo", cargo);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.cargo", bindingResult);
            return "redirect:/cargo/{id}";
        }
        cargoService.update(id, cargo);
        return "redirect:/cargo";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        if (!cargoService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "redirect:/cargo";
    }
}