package com.vm.cargosearch.controllers;

import com.vm.cargosearch.database.entity.Cargo;
import com.vm.cargosearch.dto.*;
import com.vm.cargosearch.service.*;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cargo")
@RequiredArgsConstructor
public class CargoController {
    private final CargoService cargoService;
    private final CountryService countryService;
    private final CityService cityService;
    private final KindOfTransportService kindOfTransportService;
    private final ContactService contactService;

    @GetMapping
    public String findAll(Model model,
                          @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                          @RequestParam(value = "pageSize", defaultValue = "17") int pageSize,
                          @RequestParam(value = "loadDateFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate loadDateFrom,
                          @RequestParam(value = "loadDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate loadDate,
                          @RequestParam(value = "countryLoad", required = false) String countryLoadName,
                          @RequestParam(value = "countryUnload", required = false) String countryUnloadName,
                          @RequestParam(value = "kindOfTransport", required = false) String kindOfTransportName,
                          Principal principal) {
        CountryReadDto countryLoad = countryLoadName != null ? new CountryReadDto(null, countryLoadName) : null;
        CountryReadDto countryUnload = countryUnloadName != null ? new CountryReadDto(null, countryUnloadName) : null;
        KindOfTransportReadDto kindOfTransport = kindOfTransportName != null ? new KindOfTransportReadDto(null, kindOfTransportName) : null;
        CargoFilter filter = new CargoFilter(loadDateFrom, loadDate, countryLoad, countryUnload, kindOfTransport);
        Page<Cargo> cargoPage = cargoService.findByPage(pageNo, pageSize, filter);

        if (principal != null) {
            String contactName = principal.getName();
            model.addAttribute("contactID", contactService.getIdByName(contactName));
            model.addAttribute("contactName", contactName);
        }
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", cargoPage.getTotalPages());
        model.addAttribute("totalItems", cargoPage.getTotalElements());
        model.addAttribute("cargo", cargoPage.getContent());

        return "cargo_all";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id,
                           Model model,
                           HttpSession session,
                           Principal principal) {
        CargoCreateEditDto updateCargo = (CargoCreateEditDto) session.getAttribute("cargo");
        String principalName = principal.getName();
        String contactName = cargoService.getContactFromCargo(id);
        if (principalName != null && !principalName.equals(contactName)) {
            return "error";
        }
        if (updateCargo == null) {
            updateCargo = new CargoCreateEditDto();
        }
        CargoCreateEditDto finalUpdateCargo = updateCargo;
        return cargoService.findById(id)
                .map(cargo -> {
                    model.addAttribute("cargo", cargo);
                    model.addAttribute("updateCargo", finalUpdateCargo);
                    model.addAttribute("country", countryService.findAll());
                    model.addAttribute("city", cityService.findAll());
                    model.addAttribute("transport", kindOfTransportService.findAll());

                    return "/cargo";
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("newCargo") @Validated CargoCreateEditDto cargo,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model,
                         Principal principal) {
        if (bindingResult.hasErrors()) {
            if (principal != null) {
                String contactName = principal.getName();
                model.addAttribute("contactID", contactService.getIdByName(contactName));
            }
            redirectAttributes.addFlashAttribute("newCargo", cargo);
            model.addAttribute("country", countryService.findAll());
            model.addAttribute("city", cityService.findAll());
            model.addAttribute("transport", kindOfTransportService.findAll());
            return "create_cargo";
        }
        cargoService.create(cargo);

        return "redirect:/cargo/my_cargo";
    }

    @GetMapping("/registration")
    public String registration(HttpSession session,
                               Model model,
                               Principal principal) {
        CargoCreateEditDto newCargo = (CargoCreateEditDto) session.getAttribute("newCargo");
        if (newCargo == null) {
            newCargo = new CargoCreateEditDto();
        }

        if (principal != null) {
            String contactName = principal.getName();
            model.addAttribute("contactID", contactService.getIdByName(contactName));
        }
        model.addAttribute("newCargo", newCargo);
        model.addAttribute("country", countryService.findAll());
        model.addAttribute("city", cityService.findAll());
        model.addAttribute("transport", kindOfTransportService.findAll());
        session.removeAttribute("newCargo");
        if (newCargo.getCountryLoad() != null) {
            model.addAttribute("selectedCountryLoad", newCargo.getCountryLoad().getId());
        }
        session.removeAttribute("newCargo");

        return "/create_cargo";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id,
                         @ModelAttribute("cargo") @Validated CargoUpdateDto cargoUpdateDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        Optional<CargoReadDto> cargo = cargoService.findById(id);
        if (bindingResult.hasErrors()) {
            model.addAttribute("country", countryService.findAll());
            model.addAttribute("city", cityService.findAll());
            model.addAttribute("transport", kindOfTransportService.findAll());
            cargo.ifPresent(c -> redirectAttributes.addFlashAttribute("cargo", c));
            return "cargo";
        }
        cargoService.update(id, cargoUpdateDto);

        return "redirect:/cargo/my_cargo";
    }
//    @GetMapping("/autocomplete")
//    @ResponseBody
//    public List<String> autocomplete(@RequestParam("keyword") String keyword) {
//        return countryService.findByCountryNameFilter(keyword);
//    }
//
//    @GetMapping("/autocompleteCity")
//    @ResponseBody
//    public List<String> autocompleteCity(@RequestParam("keyword") String keyword) {
//        return cityService.findByCityName(keyword);
//    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        if (!cargoService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "redirect:/cargo";
    }

    @GetMapping("/my_cargo")
    public String filterLoadingsByContact(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                          @RequestParam(value = "pageSize", defaultValue = "16") int pageSize,
                                          Model model,
                                          Principal principal) {
        String contactName = "";
        if (principal != null) {
            contactName = principal.getName();
        }
        List<Cargo> allCargosByContact = cargoService.getAllLoadingsByContactName(contactName);
        int totalItems = allCargosByContact.size();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);
        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, totalItems);
        List<Cargo> paginatedCargosByContact = allCargosByContact.subList(startIndex, endIndex);

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("cargos", paginatedCargosByContact);
        model.addAttribute("contactID", contactService.getIdByName(contactName));
        model.addAttribute("contactName", contactName);

        return "my_loadings";
    }
}
